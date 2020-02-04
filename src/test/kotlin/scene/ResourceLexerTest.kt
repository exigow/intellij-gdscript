package scene

import com.intellij.testFramework.UsefulTestCase.assertContainsElements
import junit.framework.TestCase
import scene.ResourceLexer.*
import utils.Token
import utils.tokenize

class ResourceLexerTest : TestCase() {

    fun `test resource`() =
        assertHasToken("path=\"res://icon.stex\"", Token(RESOURCE, "\"res://icon.stex\""))

    fun `test keyword`() =
        assertHasToken("flags/filter=true", Token(KEYWORD, "true"))

    fun `test number float`() =
        assertHasToken("compress/lossy_quality=0.7", Token(NUMBER, "0.7"))

    fun `test number int`() =
        assertHasToken("config_version=4", Token(NUMBER, "4"))

    private fun assertHasToken(code: String, expectedToken: Token) =
        assertContainsElements(tokenize(ResourceLanguage, ResourceLexer(null), code), expectedToken)

}