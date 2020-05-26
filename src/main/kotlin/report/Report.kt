package report

data class Report(
    val title: String?,
    val pluginVersion: String?,
    val ideVersion: String?,
    val additionalInfo: String?,
    val stacktrace: String?
)
