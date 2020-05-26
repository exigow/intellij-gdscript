package report.utils

import report.Report

object MarkdownDescriptionBaker {

    fun bake(report: Report) = createEntries(report)
        .filterValues { it != null }
        .map { bakeAttribute(it.key, it.value!!) }
        .joinToString("\n")

    private fun createEntries(report: Report) = mapOf(
        "Plugin version" to report.pluginVersion,
        "IDE version" to report.ideVersion,
        "Additional information" to report.additionalInfo,
        "Exception" to report.title,
        "Stacktrace" to report.stacktrace
    )

    private fun bakeAttribute(label: String, text: String) =
        if (isMultiline(text))
            "$label:\n```text\n$text\n```"
        else
            "$label: ```$text```"

    private fun isMultiline(text: String) =
        text.lines().size != 1

}
