package gdscript.lexer.scanner

import gdscript.ScriptTokenType
import gdscript.lexer.Token
import junit.framework.TestCase

class LineCommentScannerTest : TestCase() {

    fun `test comment to file end`() {
        val comment = LineCommentScanner().scanToken("# text", 0)
        assertEquals(Token(0, 6, ScriptTokenType.LINE_COMMENT), comment)
    }

    fun `test comment to end of line`() {
        val comment = LineCommentScanner().scanToken("# a\nb", 0)
        assertEquals(Token(0, 3, ScriptTokenType.LINE_COMMENT), comment)
    }

}