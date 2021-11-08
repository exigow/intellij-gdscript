package gdscript

import com.intellij.codeInsight.editorActions.BraceMatcherBasedSelectioner
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import common.ResourceUtil
import gdscript.psi.ScriptElementTypes.DOUBLE_QUOTED_STRING
import gdscript.psi.ScriptElementTypes.SINGLE_QUOTED_STRING

class ScriptExtendWordHandler : BraceMatcherBasedSelectioner() {

    override fun canSelect(e: PsiElement): Boolean =
        e.containingFile.fileType is ScriptFileType

    override fun select(
        element: PsiElement,
        editorText: CharSequence,
        cursorOffset: Int,
        editor: Editor
    ): List<TextRange>? {
        if (isResource(element))
            return selectResource(element)
        return super.select(element, editorText, cursorOffset, editor)
    }

    private fun isResource(element: PsiElement): Boolean {
        val type = element.elementType
        val isString = type == DOUBLE_QUOTED_STRING || type == SINGLE_QUOTED_STRING
        return isString && ResourceUtil.isResource(element.text)
    }

    private fun selectResource(string: PsiElement): List<TextRange> {
        val startOffset = string.textRange.startOffset + ResourceUtil.RESOURCE_PREFIX.length + 1
        val endOffset = string.textRange.endOffset - 1
        return listOf(TextRange.create(startOffset, endOffset))
    }

}
