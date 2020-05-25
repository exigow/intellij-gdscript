package report

import junit.framework.TestCase

class ReportToGithubLinkConverterTest : TestCase() {

    fun `test encodes all parameters properly`() {
        val issue = Report("npe", "first\n\tnext\n")
        val link = ReportToGithubLinkConverter.convertToUrl(issue)
        val expected = "https://github.com/exigow/intellij-gdscript/issues/new?labels=bug&title=npe&body=first%0A%09next%0A"
        assertEquals(expected, link)
    }

}