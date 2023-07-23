package error

import junit.framework.TestCase

class ErrorDetailsTest : TestCase() {

    fun `test error`() {
        val error = ErrorDetails(
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
        val markdown = error.toMarkdown()
        val expectedMarkdown = """
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
        assertEquals(expectedMarkdown, markdown)
    }

    fun `test null report will result empty markdown`() {
        val markdown = ErrorDetails(null, null, null, null, null).toMarkdown()
        assertEquals("", markdown)
    }

}
