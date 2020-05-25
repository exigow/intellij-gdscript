package report

import java.net.URLEncoder

object ReportToGithubLinkConverter {

    fun convertToUrl(report: Report): String {
        val params = encodeParams(mapOf(
            "labels" to report.labels,
            "title" to report.title,
            "body" to report.text
        ))
        return "https://github.com/exigow/intellij-gdscript/issues/new?$params"
    }

    private fun encodeParams(params: Map<String, String>): String =
        params.map { (key, value) -> key to URLEncoder.encode(value, "UTF-8") }
            .joinToString("&") { (key, value) -> "$key=$value" }

}