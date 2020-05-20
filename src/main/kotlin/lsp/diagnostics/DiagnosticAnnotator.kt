package lsp.diagnostics

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.ExternalAnnotator
import com.intellij.openapi.components.service
import com.intellij.psi.PsiFile
import gdscript.ScriptFileType
import lsp.LanguageServerService

class DiagnosticAnnotator : ExternalAnnotator<PsiFile, List<Diagnostic>>() {

    override fun collectInformation(file: PsiFile): PsiFile? {
        if (file.fileType is ScriptFileType) {
            file.project.service<DiagnosticService>()
                .invalidate(file.virtualFile)
            file.project.service<LanguageServerService>()
                .didOpen(file.virtualFile)
            return file
        }
        return null
    }

    override fun doAnnotate(file: PsiFile): List<Diagnostic> {
        return file.project.service<DiagnosticService>()
            .get(file.virtualFile)
    }

    override fun apply(file: PsiFile, allDiagnostics: List<Diagnostic>, holder: AnnotationHolder) {
        for (diagnostic in allDiagnostics)
            holder.createAnnotation(diagnostic.severity, diagnostic.range, diagnostic.message)
    }

}
