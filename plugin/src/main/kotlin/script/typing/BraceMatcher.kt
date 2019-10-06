package script.typing

import com.intellij.codeInsight.highlighting.PairedBraceMatcherAdapter
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import script.ScriptLanguage
import script.grammar.ScriptLexer.*

class BraceMatcher : PairedBraceMatcherAdapter(BasePairedBraceMatcher(), ScriptLanguage) {

    override fun findPair(left: Boolean, iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType): BracePair? {
        for (pair in pairs) {
            val tokenType = (iterator.tokenType as TokenIElementType).antlrTokenType
            if (tokenType == PARENTHES_LEFT || tokenType == BRACKET_LEFT)
                return pair
        }
        return null
    }

    class BasePairedBraceMatcher : PairedBraceMatcher {

        override fun getPairs() = PAIRS

        override fun isPairedBracesAllowedBeforeType(lbrace: IElementType, context: IElementType?) = true

        override fun getCodeConstructStart(file: PsiFile, openingOffset: Int): Int = openingOffset

        companion object {
            val PAIRS = mapOf(PARENTHES_LEFT to PARENTHES_RIGHT, BRACKET_LEFT to BRACKET_RIGHT)
                .map { (k, v) -> BracePair(createType(k), createType(v), false) }
                .toTypedArray()

            private fun createType(token: Int) = IElementType(VOCABULARY.getDisplayName(token), ScriptLanguage)
        }

    }

}
