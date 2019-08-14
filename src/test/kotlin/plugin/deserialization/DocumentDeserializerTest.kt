package plugin.deserialization

import org.junit.Test
import plugin.deserialization.models.Constant
import plugin.deserialization.models.Document
import plugin.deserialization.models.Member
import plugin.deserialization.models.Method
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class DocumentDeserializerTest {

    private val deserializer = DocumentDeserializer()

    @Test
    fun `deserialize methods`() {
        val method = deserializer.deserializeResource("Color.xml").findMethod("inverted")
        assertEquals(method, Method(name = "inverted"))
    }

    @Test
    fun `deserialize constants`() {
        val constant = deserializer.deserializeResource("Color.xml").findConstant("blue")
        assertEquals(constant.name, "blue")
        assertEquals(constant.value, "Color( 0, 0, 1, 1 )")
    }

    @Test
    fun `deserialize members`() {
        val member = deserializer.deserializeResource("Color.xml").findMember("r")
        assertEquals(member.name, "r")
        assertEquals(member.type, "float")
    }

    @Test
    fun `deserialize inherits`() {
        val sprite = deserializer.deserializeResource("Sprite.xml")
        assertNotNull(sprite.inherits)
    }

    @Test
    fun `do not nullify member setters or getters on empty strings`() {
        val test = deserializer.deserializeText("<class name=\"\" inherits=\"\"/>")
        assertNotNull(test.name)
        assertNotNull(test.inherits)
    }

    @Test
    fun `allow null inherits`() {
        val color = deserializer.deserializeResource("Color.xml")
        assertNull(color.inherits)
    }

    @Test
    fun `deserialize missing members`() {
        val doc = deserializer.deserializeResource("GDScript.xml")
        assertNull(doc.members)
    }

    @Test
    fun `deserialize tags with whitespaces as null collections`() {
        val test = deserializer.deserializeText("""
            <class name="Test2D" inherits="Test">
                <constants>
                </constants>
            </class>
        """)
        assertNull(test.constants)
    }

    private fun Document.findMember(name: String): Member = members?.find { it.name == name }!!

    private fun Document.findConstant(name: String): Constant = constants?.find { it.name == name }!!

    private fun Document.findMethod(name: String): Method = methods?.find { it.name == name }!!

}