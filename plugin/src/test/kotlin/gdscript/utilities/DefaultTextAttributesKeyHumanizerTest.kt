package gdscript.utilities

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import gdscript.utilities.DefaultTextAttributesKeyHumanizer.humanize
import org.junit.Test
import kotlin.test.assertEquals

class DefaultTextAttributesKeyHumanizerTest {

    @Test fun `humanize text`() =
        assertEquals("String", humanize(DefaultLanguageHighlighterColors.STRING))

    @Test fun `humanize text with multiple words`() =
        assertEquals("Line comment", humanize(DefaultLanguageHighlighterColors.LINE_COMMENT))

}