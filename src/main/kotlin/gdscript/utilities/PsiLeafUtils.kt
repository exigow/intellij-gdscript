package gdscript.utilities

import ScriptLexer
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.util.PsiTreeUtil
import org.antlr.intellij.adaptor.lexer.TokenIElementType

object PsiLeafUtils {

    fun PsiElement.prevLeaf() =
        PsiTreeUtil.prevLeaf(this)?.asLeaf()

    fun PsiElement.isIdentifier() =
        isToken(ScriptLexer.IDENTIFIER)

    private fun PsiElement.isToken(expected: Int) =
        (this.asLeaf()?.elementType as? TokenIElementType)?.antlrTokenType == expected

    private fun PsiElement.asLeaf() =
        this as? LeafPsiElement

}