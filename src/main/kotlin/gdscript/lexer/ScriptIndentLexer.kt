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
    private val depths = mutableListOf<Int>()
    private var unfinishedIndent = false
    private var bracesLevel = 0

    override fun advance() {
        prevToken = tokenType
        prevEnd = tokenEnd
        if (pending.isEmpty())
            advanceAndProduce()
        else
            pending.removeFirst()
    }

    private fun advanceAndProduce() {
        delegate.advance()
        updateBraceLevel()
        if (prevToken == LINE_BREAK && bracesLevel == 0) {
            val depth = calcDepth()
            val maxDepth = depths.maxOrNull() ?: 0
            if (depth > maxDepth) {
                pending += INDENT
                depths += depth
                unfinishedIndent = true
            } else if (depth < maxDepth) {
                val iter = depths.iterator()
                while (iter.hasNext() && iter.next() > depth) {
                    iter.remove()
                    pending += DEDENT
                    unfinishedIndent = false
                }
            }
        }
        if (tokenEnd == bufferEnd && tokenType == null && unfinishedIndent) {
            pending += DEDENT
            unfinishedIndent = true
        }
    }

    private fun calcDepth(): Int {
        if (tokenType == WHITE_SPACE)
            return tokenText
                .map { c -> if (c == '\t') 4 else 1 }
                .sum()
        return 0
    }

    private fun updateBraceLevel() {
        if (tokenType in OPENING_BRACES)
            bracesLevel += 1
        if (tokenType in CLOSING_BRACES)
            bracesLevel -= 1
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

    private companion object {

        val OPENING_BRACES = listOf(L_BRACE, L_BRACKET, L_PAREN)
        val CLOSING_BRACES = listOf(R_BRACE, R_BRACKET, R_PAREN)

    }

}