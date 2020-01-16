package uitlities

import junit.framework.TestCase.fail
import kotlin.test.assertEquals

inline fun <reified ExpectedException : Exception> assertExceptionThrown(invoke: () -> Unit, expectedMessage: String) {
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
