package report.utils

import java.net.URLEncoder

object GithubLinkGenerator {

    fun generateUrl(title: String, body: String): String {
        val encodedTitle = encode(title)
        val encodedBody = encode(body)
        return "https://github.com/exigow/intellij-gdscript/issues/new" +
            "?labels=bug" +
            "&title=$encodedTitle" +
            "&body=$encodedBody"
    }

    private fun encode(text: String) =
        URLEncoder.encode(text, "UTF-8")

}
