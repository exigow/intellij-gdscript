package uitlities

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue


fun <T> assertContains(list: List<T>?, expected: T) =
    assertTrue(expected in list!!)


fun <T> assertNotContains(list: List<T>?, unwanted: T) =
    assertFalse(unwanted in list!!)
