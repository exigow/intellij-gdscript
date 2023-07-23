package gdscript

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import gdscript.psi.ScriptElementTypes.*

class ScriptBraceMatcher : PairedBraceMatcher {

    override fun getPairs() = arrayOf(
        BracePair(L_PAREN, R_PAREN, false),
        BracePair(L_BRACKET, R_BRACKET, false),
        BracePair(L_BRACE, R_BRACE, false)
    )

    override fun isPairedBracesAllowedBeforeType(left: IElementType, context: IElementType?): Boolean =
        true

    override fun getCodeConstructStart(file: PsiFile, openingBraceOffset: Int): Int =
        openingBraceOffset

}
