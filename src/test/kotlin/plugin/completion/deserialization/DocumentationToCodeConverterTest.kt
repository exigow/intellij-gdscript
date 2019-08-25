package plugin.completion.deserialization

import org.junit.Assert.assertEquals
import org.junit.Test
import plugin.completion.deserialization.DocumentationToCodeConverter.generate
import plugin.completion.deserialization.models.Documentation
import plugin.completion.deserialization.models.Member

// todo: more tests
class DocumentationToCodeConverterTest {

    @Test
    fun `test minimal`() {
        val doc = Documentation("Minimal", null, null, null, null, null) // todo: hide nulls
        assertEquals("class_name Minimal", generate(doc))
    }

    @Test
    fun `test extends`() {
        val doc = Documentation("Sprite", "Node2D", null, null, null, null)
        val expected = "extends Node2D\n\nclass_name Sprite"
        assertEquals(expected, generate(doc))
    }

    @Test
    fun `test variable`() {
        val member = Member("x", "float", null, null, null)
        val doc = Documentation("Vector2", null, listOf(member), null, null, null)
        val expected = "class_name Vector2\n\nvar x: float"
        assertEquals(expected, generate(doc))
    }

}