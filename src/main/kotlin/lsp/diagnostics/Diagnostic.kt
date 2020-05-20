package lsp.diagnostics

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.VirtualFile

data class Diagnostic(
    val file: VirtualFile,
    val range: TextRange,
    val message: String,
    val severity: HighlightSeverity
)