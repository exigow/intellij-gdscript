package plugin.completion.deserialization

import org.junit.Assert.assertEquals
import org.junit.Test

class ColorDeserializerTest {

    @Test
    fun `deserialize tomato`() {
        val color = ColorDeserializer.deserialize("Color( 1, 0.39, 0.28, 1 )")
        assertEquals(color.red, 255)
        assertEquals(color.green, 99)
        assertEquals(color.blue, 71)
    }

}