package gdscript.colors

import org.junit.Test

class GdColorSettingsPageTest {

    @Test
    fun `color option names are humanized programmatically from attributes`() {
        val displayNames = GdColorSettingsPage().attributeDescriptors
            .map { it.displayName }
        assertContains("Parameter", displayNames)
        assertContains("Keyword", displayNames)
    }

    private fun assertContains(contained: String, container: Collection<String>) = container.findLast { it == contained }!!

}