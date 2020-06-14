package gdscript.lexer.scanner

import gdscript.ScriptTokenType.NODE
import gdscript.lexer.Token
import junit.framework.TestCase


class NodeScannerTest : TestCase() {

    fun `test path with directory`() {
        val token = NodeScanner().scanToken("\$Some/Node", 0)
        assertEquals(Token(0, 10, NODE), token)
    }

}