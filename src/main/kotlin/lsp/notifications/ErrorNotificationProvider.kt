package lsp.notifications

import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.service
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.EditorNotificationPanel
import com.intellij.ui.EditorNotifications
import gdscript.ScriptFileType
import lsp.LanguageServerService
import settings.ApplicationSettings


class ErrorNotificationProvider(
    private val project: Project
) : EditorNotifications.Provider<EditorNotificationPanel>() {

    private val lspService = project.service<LanguageServerService>()
    private var ignored = false

    override fun getKey() = PANEL_KEY

    override fun createNotificationPanel(file: VirtualFile, editor: FileEditor, project: Project): EditorNotificationPanel? {
        if (!ServiceManager.getService(ApplicationSettings::class.java).lspEnabled)
            return null
        if (file.fileType !is ScriptFileType)
            return null
        if (ignored)
            return null
        if (lspService.isAlive())
            return null
        return createPanel()
    }

    private fun createPanel(): EditorNotificationPanel {
        val panel = EditorNotificationPanel()
        panel.setText("Real-time diagnostics are disabled for this file. To enable LSP features open project in Godot editor.")
        panel.createActionLabel("Re-connect", ::reconnect)
        panel.createActionLabel("Ignore", ::ignore)
        return panel
    }

    private fun reconnect() {
        lspService.startServer()
        if (lspService.isAlive())
            ConnectionStatusNotifier.notify(project, "Connected successfully.")
        else
            ConnectionStatusNotifier.notify(project, "Connection failure.")
        updateNotifications()
    }

    private fun ignore() {
        ignored = true
        updateNotifications()
    }

    private fun updateNotifications() =
        EditorNotifications.getInstance(project).updateAllNotifications()

    private companion object {

        private val PANEL_KEY = Key.create<EditorNotificationPanel>("LSP issues")

    }

}