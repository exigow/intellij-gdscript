package utils

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import junit.framework.TestCase.fail
import junit.framework.TestCase.assertEquals

inline fun <reified ExpectedException : Exception> assertThrows(
    invoke: () -> Unit, expectedMessage: String
) {
    try {
        invoke()
    } catch (exception: Exception) {
        if (exception is ExpectedException) {
            assertEquals(expectedMessage, exception.message)
            return
        }
        throw exception
    }
    fail("Expected exception ${ExpectedException::class.java} not thrown")
}


fun assertHasHighlight(highlights: List<HighlightInfo>, expectedText: String, expectedKey: String) {
    val annotation = highlights.find { it.text == expectedText }!!
    assertEquals(expectedKey, annotation.forcedTextAttributesKey.externalName)
}
