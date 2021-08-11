package tscn

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import tscn.psi.TscnElementTypes.*


class TscnBraceMatcher : PairedBraceMatcher {

    override fun getPairs() = arrayOf(
        BracePair(L_PAREN, R_PAREN, false),
        BracePair(L_BRACKET, R_BRACKET, false),
        BracePair(L_CURLY, R_CURLY, false)
    )

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?) =
        true

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int =
        openingBraceOffset

}