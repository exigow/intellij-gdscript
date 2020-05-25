package report

import java.net.URLEncoder

object ReportToGithubLinkConverter {

    fun convertToUrl(report: Report): String {
        val title = encode(report.title)
        val body = encode(report.body)
        return "https://github.com/exigow/intellij-gdscript/issues/new?labels=bug&title=$title&body=$body"
    }

    private fun encode(value: String) =
        URLEncoder.encode(value, "UTF-8")

}