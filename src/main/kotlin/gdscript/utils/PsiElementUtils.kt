package gdscript.utils

import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.tree.IElementType
import gdscript.psi.ScriptTypes

object PsiElementUtils {

    fun PsiElement.isLeaf(expected: IElementType): Boolean {
        val leaf = this as? LeafPsiElement
        return leaf?.elementType == expected
    }

    fun PsiElement.stringText(): String {
        if (text.startsWith("\""))
            return text.removeSurrounding("\"")
        if (text.startsWith("\'"))
            return text.removeSurrounding("\'")
        return text
    }

    fun PsiElement.isStringLeaf() =
        isLeaf(ScriptTypes.DOUBLE_QUOTED_STRING) || isLeaf(ScriptTypes.SINGLE_QUOTED_STRING)

}