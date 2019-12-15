package uitlities

import junit.framework.TestCase.fail

inline fun <reified ExpectedException : Exception> assertExceptionThrown(invoke: () -> Unit) {
    try {
        invoke()
    } catch (exc: Exception) {
        if (exc is ExpectedException)
            return
        throw exc
    }
    fail("No ${ExpectedException::class.java} was thrown during the test")
}
