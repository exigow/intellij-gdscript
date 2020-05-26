package report

import com.intellij.ide.BrowserUtil
import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.openapi.diagnostic.ErrorReportSubmitter
import com.intellij.openapi.diagnostic.IdeaLoggingEvent
import com.intellij.openapi.diagnostic.SubmittedReportInfo
import com.intellij.openapi.diagnostic.SubmittedReportInfo.SubmissionStatus.FAILED
import com.intellij.openapi.diagnostic.SubmittedReportInfo.SubmissionStatus.NEW_ISSUE
import com.intellij.util.Consumer
import report.utils.GithubLinkGenerator
import report.utils.MarkdownDescriptionBaker
import java.awt.Component

class ReportSubmitter : ErrorReportSubmitter() {

    override fun getReportActionText() =
        "Open GitHub issue"

    override fun submit(
        events: Array<IdeaLoggingEvent>,
        additionalInfo: String?,
        parentComponent: Component,
        consumer: Consumer<SubmittedReportInfo>
    ): Boolean {
        try {
            if (events.isNotEmpty()) {
                val event = events.first()
                val issue = collectIssueDetails(event, additionalInfo)
                submitOnGithub(issue)
            }
        } catch (e: Exception) {
            consumer.consume(SubmittedReportInfo(FAILED))
            return false
        }
        consumer.consume(SubmittedReportInfo(NEW_ISSUE))
        return true
    }

    private fun collectIssueDetails(event: IdeaLoggingEvent, additionalInfo: String?) =
        Report(
            title = event.throwableText.lines().first(),
            pluginVersion = discoverPluginVersion(),
            additionalInfo = additionalInfo,
            stacktrace = event.throwableText
        )

    private fun discoverPluginVersion() =
        (pluginDescriptor as? IdeaPluginDescriptor)?.version

    private fun submitOnGithub(report: Report) {
        val markdown = MarkdownDescriptionBaker.bake(report)
        val title = report.title ?: "no title"
        val url = GithubLinkGenerator.generateUrl(title, markdown)
        BrowserUtil.browse(url)
    }

}
