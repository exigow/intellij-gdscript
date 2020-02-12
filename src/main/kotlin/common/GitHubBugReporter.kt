package common

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.diagnostic.ErrorReportSubmitter
import com.intellij.openapi.diagnostic.IdeaLoggingEvent
import com.intellij.openapi.diagnostic.SubmittedReportInfo
import com.intellij.openapi.diagnostic.SubmittedReportInfo.SubmissionStatus.FAILED
import com.intellij.openapi.diagnostic.SubmittedReportInfo.SubmissionStatus.NEW_ISSUE
import com.intellij.util.Consumer
import java.awt.Component
import java.net.URLEncoder

class GitHubBugReporter : ErrorReportSubmitter() {

    override fun getReportActionText() =
        "Open GitHub issue"

    override fun submit(events: Array<IdeaLoggingEvent>, additionalInfo: String?, parentComponent: Component, consumer: Consumer<SubmittedReportInfo>): Boolean {
        try {
            submitEventsOnGithub(events)
        } catch (e: Exception) {
            consumer.consume(SubmittedReportInfo(FAILED))
            return false
        }
        consumer.consume(SubmittedReportInfo(NEW_ISSUE))
        return true
    }

    private fun submitEventsOnGithub(events: Array<IdeaLoggingEvent>) {
        val issue = GitHubIssue(
            title = discoverStacktraceTitle(events),
            labels = "bug",
            text = discoverStacktraceContents(events)
        )
        val githubLink = convertToLink(issue)
        BrowserUtil.browse(githubLink)
    }

    private fun discoverStacktraceTitle(events: Array<IdeaLoggingEvent>): String =
        events.firstOrNull()
            ?.throwableText
            ?.lines()
            ?.first()
            ?.trim()
            ?: "Bug"

    private fun discoverStacktraceContents(events: Array<IdeaLoggingEvent>) =
        events.map { it.throwableText }
            .filter { it.isNotBlank() }
            .joinToString { "```\n$it\n```\n" }

    private fun convertToLink(issue: GitHubIssue): String {
        val params = encodeParams(mapOf(
            "labels" to issue.labels,
            "title" to issue.title,
            "body" to issue.text
        ))
        return "https://github.com/exigow/intellij-gdscript/issues/new?$params"
    }

    private fun encodeParams(params: Map<String, String>): String =
        params.map { (key, value) -> key to URLEncoder.encode(value, "UTF-8") }
            .joinToString("&") { (key, value) -> "$key=$value" }

    private data class GitHubIssue(
        val title: String,
        val labels: String,
        val text: String
    )

}