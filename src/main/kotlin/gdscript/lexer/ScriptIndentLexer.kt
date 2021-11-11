package gdscript.lexer

import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import gdscript.psi.ScriptElementTypes.*

class ScriptIndentLexer : LexerBase() {

    private val delegate = ScriptLexerAdapter()
    private val pending = mutableListOf<IElementType>()
    private var lastEnd = 0

    init {
        pending += INDENT
        pending += DEDENT
        pending += INDENT
        pending += DEDENT
    }

    override fun advance() {
        lastEnd = tokenEnd
        if (pending.isEmpty())
            advanceAndProduce()
        else
            pending.removeLast()
    }

    private fun advanceAndProduce() {
        if (tokenType == LINE_BREAK) {
            pending += INDENT
            pending += DEDENT
        }
        delegate.advance()
    }

    override fun getTokenType(): IElementType? {
        if (pending.isEmpty())
            return delegate.tokenType
        return pending.last()
    }

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        delegate.start(buffer, startOffset, endOffset, initialState)
    }

    override fun getState(): Int =
        delegate.state

    override fun getTokenStart(): Int {
        if (pending.isEmpty())
            return delegate.tokenStart
        return lastEnd
    }

    override fun getTokenEnd(): Int {
        if (pending.isEmpty())
            return delegate.tokenEnd
        return lastEnd
    }

    override fun getBufferSequence(): CharSequence =
        delegate.bufferSequence

    override fun getBufferEnd(): Int =
        delegate.bufferEnd

}