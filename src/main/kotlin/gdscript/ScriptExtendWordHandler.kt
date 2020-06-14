package gdscript

import com.intellij.codeInsight.editorActions.BraceMatcherBasedSelectioner
import com.intellij.psi.PsiElement

class ScriptExtendWordHandler : BraceMatcherBasedSelectioner() {

    override fun canSelect(e: PsiElement): Boolean =
        e.containingFile.fileType is ScriptFileType

}
