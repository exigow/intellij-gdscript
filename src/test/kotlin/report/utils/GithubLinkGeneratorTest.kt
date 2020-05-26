package report.utils

import junit.framework.TestCase

class GithubLinkGeneratorTest : TestCase() {

    fun `test encodes all parameters properly`() {
        val title = "test"
        val body = "test\ntest"
        val generated = GithubLinkGenerator.generateUrl(title, body)
        val expected = "https://github.com/exigow/intellij-gdscript/issues/new?labels=bug&title=test&body=test%0Atest"
        assertEquals(expected, generated)
    }

}