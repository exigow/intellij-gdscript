package gdscript.lexer

import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import gdscript.ScriptTokenType
import gdscript.lexer.scanner.*

class ScriptLexer : LexerBase() {

    private lateinit var buffer: CharSequence
    private var start: Int = 0
    private var end: Int = 0
    private var token: Token? = null
    private var position = 0

    override fun start(buffer: CharSequence, start: Int, end: Int, state: Int) {
        this.buffer = buffer
        this.start = start
        this.end = end
        position = start
        advance()
    }

    override fun advance() {
        if (position >= buffer.length) {
            token = null
            return
        }
        token = TOKEN_SCANNERS
            .mapNotNull { it.scanToken(buffer, position) }
            .firstOrNull()
            ?: Token(position, position + 1, ScriptTokenType.UNRECOGNIZED)
        position = tokenEnd
    }

    override fun getState(): Int = 0

    override fun getTokenType(): IElementType? = token?.type

    override fun getTokenStart(): Int = token?.start ?: 0

    override fun getTokenEnd(): Int = token?.end ?: 0

    override fun getBufferSequence(): CharSequence = buffer

    override fun getBufferEnd(): Int = buffer.length

    private companion object {

        val TOKEN_SCANNERS = listOf(
            TrieScanner(setOf("\n"), ScriptTokenType.END_OF_LINE),
            WhitespaceScanner(),
            TrieScanner(setOf(","), ScriptTokenType.COMMA),
            TrieScanner(setOf("->"), ScriptTokenType.ARROW),
            TrieScanner(setOf(":"), ScriptTokenType.COLON),
            TrieScanner(setOf("."), ScriptTokenType.DOT),
            TrieScanner(setOf(";"), ScriptTokenType.SEMICOLON),
            TrieScanner(setOf("{"), ScriptTokenType.BRACE_LEFT),
            TrieScanner(setOf("}"), ScriptTokenType.BRACE_RIGHT),
            TrieScanner(setOf("("), ScriptTokenType.PARENTH_LEFT),
            TrieScanner(setOf(")"), ScriptTokenType.PARENTH_RIGHT),
            TrieScanner(setOf("["), ScriptTokenType.BRACKET_LEFT),
            TrieScanner(setOf("]"), ScriptTokenType.BRACKET_RIGHT),
            StringScanner(),
            LineCommentScanner(),
            NodeScanner(),
            IdentifierScanner(),
            NumberScanner()
        )

    }

}