package report.utils

import junit.framework.TestCase
import report.Report

class MarkdownDescriptionBakerTest : TestCase() {

    fun `test happy path`() {
        val report = Report(
            title = "java.lang.NullPointerException",
            pluginVersion = "0.26.1",
            ideVersion = "IC-193.5233.102",
            additionalInfo = null,
            stacktrace = """
            java.lang.NullPointerException: Something bad happened
                at com.example.Some.handle(Some.java:326)
                ... 54 more
            """.trimIndent()
        )
        val markdown = MarkdownDescriptionBaker.bake(report)
        val expected = """
            Plugin version: ```0.26.1```
            IDE version: ```IC-193.5233.102```
            Exception: ```java.lang.NullPointerException```
            Stacktrace:
            ```text
            java.lang.NullPointerException: Something bad happened
                at com.example.Some.handle(Some.java:326)
                ... 54 more
            ```
        """.trimIndent()
        assertEquals(expected, markdown)
    }

    fun `test empty report should output empty markdown`() {
        val empty = Report(null, null, null, null, null)
        val emptyMarkdown = MarkdownDescriptionBaker.bake(empty)
        assertEquals("", emptyMarkdown)
    }

}