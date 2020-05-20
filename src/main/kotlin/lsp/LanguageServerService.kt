package lsp

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.openapi.fileEditor.impl.LoadTextUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.EditorNotifications
import lsp.diagnostics.DiagnosticService
import lsp.io.QuietInputStream
import lsp.io.QuietOutputStream
import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.jsonrpc.services.JsonNotification
import org.eclipse.lsp4j.launch.LSPLauncher
import org.eclipse.lsp4j.services.LanguageServer
import settings.SettingsComponent
import java.io.IOException
import java.net.Socket


@Service
class LanguageServerService(
    private val project: Project
) {

    private var server: LanguageServer? = null

    fun isAlive() =
        server != null

    fun didOpen(file: VirtualFile) {
        startServer()
        if (server != null) {
            val item = TextDocumentItem()
            item.uri = file.url
            item.text = LoadTextUtil.loadText(file).toString()
            val params = DidOpenTextDocumentParams()
            params.textDocument = item
            server!!.textDocumentService.didOpen(params)
        }
    }

    fun completion(file: VirtualFile, line: Int, character: Int): List<CompletionItem> {
        startServer()
        if (server != null) {
            val params = CompletionParams(TextDocumentIdentifier(file.url), Position(line, character))
            return server!!.textDocumentService.completion(params)
                .get().left
        }
        return emptyList()
    }

    fun startServer() {
        if (!SettingsComponent.INSTANCE.settings.lspEnabled) {
            server = null
            return
        }
        if (server == null) {
            try {
                val socket = Socket("localhost", 6008)
                val launcher = LSPLauncher.Builder<LanguageServer>()
                    .setLocalService(LocalService())
                    .setRemoteInterface(LanguageServer::class.java)
                    .setInput(QuietInputStream(socket.getInputStream(), ::stopServer))
                    .setOutput(QuietOutputStream(socket.getOutputStream(), ::stopServer))
                    .create()
                launcher.startListening()
                server = launcher.remoteProxy
                EditorNotifications.getInstance(project).updateAllNotifications()
            } catch (ignored: IOException) {
            }
        }
    }

    private fun stopServer(ioe: IOException) {
        server = null
        EditorNotifications.getInstance(project).updateAllNotifications()
    }

    inner class LocalService {

        @JsonNotification("textDocument/publishDiagnostics")
        fun publishDiagnostics(params: PublishDiagnosticsParams) {
            ApplicationManager.getApplication().invokeLater {
                val parsed = PublishDiagnosticsParamsParser.parse(params)
                project.service<DiagnosticService>().register(parsed)
            }
        }

    }

}