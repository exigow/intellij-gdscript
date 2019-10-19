package uitlities

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue


fun <T> assertContains(list: List<T>?, element: T) =
    assertTrue(element in list!!)


fun <T> assertNotContains(list: List<T>?, element: T) =
    assertFalse(element in list!!)
