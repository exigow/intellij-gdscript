package lsp

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.LogicalPosition
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import lsp.diagnostics.Diagnostic
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.PublishDiagnosticsParams
import org.eclipse.lsp4j.Diagnostic as Lsp4jDiagnostic

internal object PublishDiagnosticsParamsParser {

    fun parse(params: PublishDiagnosticsParams): List<Diagnostic> {
        val file = VirtualFileManager.getInstance().findFileByUrl(params.uri)!!
        val result = mutableListOf<Diagnostic>()
        for (message in params.diagnostics) {
            val range = parseRange(message, file)
            val severity = parseSeverity(message.severity.value)
            result += Diagnostic(file, range, message.message, severity)
        }
        return result
    }

    private fun parseRange(message: Lsp4jDiagnostic, file: VirtualFile): TextRange {
        val from = convertToOffset(message.range.start, file)
        val to = convertToOffset(message.range.end, file)
        return TextRange(from, to)
    }

    private fun convertToOffset(range: Position, file: VirtualFile): Int {
        val position = LogicalPosition(range.line, range.character)
        val document = FileDocumentManager.getInstance().getDocument(file)!!
        return document.getLineStartOffset(position.line) + position.column
    }

    private fun parseSeverity(severity: Int): HighlightSeverity =
        when (severity) {
            1 -> HighlightSeverity.ERROR
            2 -> HighlightSeverity.WARNING
            3, 4 -> HighlightSeverity.INFORMATION
            else -> throw RuntimeException("Unrecognized severity $severity")
        }

}