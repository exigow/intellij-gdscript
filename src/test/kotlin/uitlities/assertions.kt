package uitlities

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue


fun <T> assertContains(list: Iterable<T>?, element: T) =
    assertTrue(element in list!!)

fun <T> assertNotContains(list: Iterable<T>?, element: T) =
    assertFalse(element in list!!)
