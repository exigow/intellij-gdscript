package plugin.completion.deserialization.utilities

import org.junit.Assert.assertEquals
import org.junit.Test

class ColorParserTest {

    @Test
    fun `parse tomato color`() {
        val color = ColorParser.parse("Color( 1, 0.39, 0.28, 1 )")
        assertEquals(color.red, 255)
        assertEquals(color.green, 99)
        assertEquals(color.blue, 71)
    }

}