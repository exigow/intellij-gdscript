package gdscript.utilities

import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.util.PsiTreeUtil
import org.antlr.intellij.adaptor.lexer.TokenIElementType

object PsiLeafUtils {

    fun PsiElement.isAfterText(text: String) =
        prevLeaf()?.text == text

    fun PsiElement.isBeforeText(text: String) =
        nextLeaf()?.text == text

    fun PsiElement.prevLeaf() =
        PsiTreeUtil.prevLeaf(this)?.asLeaf()

    fun PsiElement.nextLeaf() =
        PsiTreeUtil.nextLeaf(this)?.asLeaf()

    fun PsiElement.isIdentifier() =
        isToken(ScriptLexer.IDENTIFIER)

    private fun PsiElement.isToken(expected: Int) =
        (this.asLeaf()?.elementType as? TokenIElementType)?.antlrTokenType == expected

    private fun PsiElement.asLeaf() =
        this as? LeafPsiElement

}