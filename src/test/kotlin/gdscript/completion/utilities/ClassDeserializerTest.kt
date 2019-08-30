package gdscript.completion.utilities

import gdscript.completion.utilities.ClassDeserializer.deserializeResource
import gdscript.completion.utilities.ClassDeserializer.deserializeText
import gdscript.completion.utilities.models.*
import org.junit.Assert.*
import org.junit.Test

class ClassDeserializerTest {
    
    @Test
    fun `deserialize methods`() {
        val method = deserializeResource("/docs/Vector2.xml").findMethod("angle_to")
        val expected = Method(
            name = "angle_to",
            returnType = Return("float"),
            description = "Returns the angle in radians between the two vectors."
        )
        assertEquals(method, expected)
    }

    @Test
    fun `deserialize constants`() {
        val constant = deserializeResource("/docs/Color.xml").findConstant("blue")
        assertEquals(constant.name, "blue")
        assertEquals(constant.value, "Color( 0, 0, 1, 1 )")
    }

    @Test
    fun `deserialize members`() {
        val member = deserializeResource("/docs/Color.xml").findMember("r")
        assertEquals(member.name, "r")
        assertEquals(member.type, "float")
    }

    @Test
    fun `deserialize inherits`() {
        val sprite = deserializeResource("/docs/Sprite.xml")
        assertNotNull(sprite.inherits)
    }

    @Test
    fun `do not nullify member setters or getters on empty strings`() {
        val test = deserializeText("<class name=\"\" inherits=\"\"/>")
        assertNotNull(test.name)
        assertNotNull(test.inherits)
    }

    @Test
    fun `allow null inherits`() {
        val color = deserializeResource("/docs/Color.xml")
        assertNull(color.inherits)
    }

    @Test
    fun `deserialize missing members`() {
        val doc = deserializeResource("/docs/GDScript.xml")
        assertNull(doc.members)
    }

    @Test
    fun `deserialize tags with whitespaces as null collections`() {
        val test = deserializeText("""
            <class name="Test2D" inherits="Test">
                <constants>
                </constants>
            </class>
        """)
        assertNull(test.constants)
    }

    private fun Class.findMember(name: String): Member =
        members?.find { it.name == name }!!

    private fun Class.findConstant(name: String): Constant =
        constants?.find { it.name == name }!!

    private fun Class.findMethod(name: String): Method =
        methods?.find { it.name == name }!!

}