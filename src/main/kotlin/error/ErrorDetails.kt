package error

data class ErrorDetails(
    val title: String?,
    val pluginVersion: String?,
    val ideVersion: String?,
    val additionalInfo: String?,
    val stacktrace: String?
) {

    fun toMarkdown() = mapOf(
        "Plugin version" to pluginVersion,
        "IDE version" to ideVersion,
        "Additional information" to additionalInfo,
        "Exception" to title,
        "Stacktrace" to stacktrace
    ).filterValues { it != null }
        .map { toLabeledMonospace(it.key, it.value!!) }
        .joinToString("\n")

    private fun toLabeledMonospace(label: String, text: String) =
        if (text.lines().size != 1)
            "$label:\n```text\n$text\n```"
        else
            "$label: ```$text```"

}
