package report.utils

import junit.framework.TestCase
import report.Report

class MarkdownDescriptionBakerTest : TestCase() {

    fun `test happy path`() {
        val report = Report(
            "java.lang.NullPointerException",
            "0.26.1",
            null,
            """
            java.lang.NullPointerException: Something bad happened
                at com.example.Some.handle(Some.java:326)
                ... 54 more
            """.trimIndent()
        )
        val markdown = MarkdownDescriptionBaker.bake(report)
        val expected = """
            Plugin version: ```0.26.1```
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
        val empty = Report(null, null, null, null)
        val emptyMarkdown = MarkdownDescriptionBaker.bake(empty)
        assertEquals("", emptyMarkdown)
    }

}