package gdscript

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import gdscript.psi.ScriptTypes

class ScriptBraceMatcher : PairedBraceMatcher {

    override fun getPairs(): Array<BracePair> =
        PAIRS

    override fun isPairedBracesAllowedBeforeType(left: IElementType, context: IElementType?): Boolean =
        context === ScriptTypes.COMMA ||
        context === ScriptTypes.DOT ||
        context === TokenType.WHITE_SPACE ||
        isRBraceToken(context)

    override fun getCodeConstructStart(file: PsiFile, openingBraceOffset: Int): Int =
        openingBraceOffset

    companion object {

        private val PAIRS = arrayOf(
            BracePair(ScriptTypes.BRACKET_LEFT, ScriptTypes.BRACKET_RIGHT, true),
            BracePair(ScriptTypes.PARENTH_LEFT, ScriptTypes.PARENTH_RIGHT, true),
            BracePair(ScriptTypes.BRACE_LEFT, ScriptTypes.BRACE_RIGHT, true)
        )

        private fun isRBraceToken(type: IElementType?): Boolean =
            PAIRS.any { type === it.rightBraceType }

    }
}