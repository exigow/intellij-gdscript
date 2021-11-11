package gdscript.lexer

import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType
import gdscript.psi.ScriptElementTypes.*

class ScriptIndentLexer : LexerBase() {

    private val delegate = ScriptLexerAdapter()
    private val pending = mutableListOf<IElementType>()
    private var prevEnd = 0
    private var prevToken: IElementType? = null

    override fun advance() {
        prevToken = delegate.tokenType
        prevEnd = delegate.tokenEnd
        if (pending.isEmpty())
            advanceAndProduce()
        else
            pending.removeFirst()
    }

    private fun advanceAndProduce() {
        delegate.advance()
        if (prevToken == LINE_BREAK) {
            val depth = calcDepth()
            println("current $tokenType, prev $prevToken, depth: $depth")
            pending += INDENT
            pending += DEDENT
        }
    }

    private fun calcDepth(): Int {
        if (tokenType == WHITE_SPACE)
            return tokenText
                .map { c -> if (c == '\t') 4 else 1 }
                .sum()
        return 0
    }

    override fun getTokenType(): IElementType? {
        if (pending.isEmpty())
            return delegate.tokenType
        return pending.first()
    }

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        delegate.start(buffer, startOffset, endOffset, initialState)
    }

    override fun getState(): Int =
        delegate.state

    override fun getTokenStart(): Int {
        if (pending.isEmpty())
            return delegate.tokenStart
        return prevEnd
    }

    override fun getTokenEnd(): Int {
        if (pending.isEmpty())
            return delegate.tokenEnd
        return prevEnd
    }

    override fun getBufferSequence(): CharSequence =
        delegate.bufferSequence

    override fun getBufferEnd(): Int =
        delegate.bufferEnd

}