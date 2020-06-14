package gdscript

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class ScriptBraceMatcher : PairedBraceMatcher {

    override fun getPairs(): Array<BracePair> =
        PAIRS

    override fun isPairedBracesAllowedBeforeType(left: IElementType, context: IElementType?): Boolean =
        context === ScriptTokenType.COMMA ||
        context === ScriptTokenType.DOT ||
            context === ScriptTokenType.WHITESPACE ||
            isRBraceToken(context)

    override fun getCodeConstructStart(file: PsiFile, openingBraceOffset: Int): Int =
        openingBraceOffset

    companion object {

        private val PAIRS = arrayOf(
            BracePair(ScriptTokenType.BRACKET_LEFT, ScriptTokenType.BRACKET_RIGHT, true),
            BracePair(ScriptTokenType.PARENTH_LEFT, ScriptTokenType.PARENTH_RIGHT, true),
            BracePair(ScriptTokenType.BRACE_LEFT, ScriptTokenType.BRACE_RIGHT, true)
        )

        private fun isRBraceToken(type: IElementType?): Boolean =
            PAIRS.any { type === it.rightBraceType }

    }
}