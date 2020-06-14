package gdscript.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import gdscript.ScriptLanguage
import gdscript.ScriptTokenType.ARROW
import gdscript.ScriptTokenType.COLON
import gdscript.ScriptTokenType.END_OF_LINE
import gdscript.ScriptTokenType.PARENTH_RIGHT

class ScriptParser : PsiParser {

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        builder.setDebugMode(true)
        val fileMarker = builder.mark()
        builder.parseContents()
        fileMarker.done(root)
        val tree = builder.treeBuilt
        return tree
    }

    private fun PsiBuilder.parseContents() {
        do {
            val statement = mark()
            when (tokenText) {
                "var" -> {
                    advanceLexer()
                    advanceLexer()
                    if (tokenText == ":") {
                        advanceLexer()
                        advanceLexer()
                    }
                    if (tokenText == "=")
                        advanceUntil { eol() || eof() }
                }
                "static", "func" -> {
                    if (tokenText == "static")
                        advanceLexer()
                    advanceUntil { tokenType == PARENTH_RIGHT || eol() || eof() }
                    advanceLexer()
                    if (tokenType == ARROW) {
                        advanceLexer()
                        advanceLexer()
                    }
                    advanceLexer()
                }
                "if", "elif", "for", "while", "class" -> {
                    advanceLexer()
                    val expression = mark()
                    advanceUntil { tokenType == COLON || eol() || eof() }
                    expression.done(EXPRESSION)
                    advanceLexer()
                }
                "else" -> {
                    advanceLexer()
                    advanceLexer()
                }
                "return" -> {
                    advanceUntil { eol() || eof() }
                }
                else -> {
                    advanceUntil { eol() || eof() }
                }
            }
            statement.done(STATEMENT)
            advanceLexer()
        } while (!eof())
    }

    private fun PsiBuilder.advanceUntil(untilPredicate: () -> Boolean) {
        do {
            advanceLexer()
        } while (!untilPredicate())
    }

    private fun PsiBuilder.eol() =
        tokenType == END_OF_LINE

    companion object {

        val STATEMENT = IElementType("STATEMENT", ScriptLanguage)
        val EXPRESSION = IElementType("EXPRESSION", ScriptLanguage)

    }

}