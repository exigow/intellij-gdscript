package run.console

import com.intellij.testFramework.UsefulTestCase.assertContainsElements
import com.intellij.testFramework.UsefulTestCase.assertEmpty
import junit.framework.TestCase


class ConsoleLinkParserTest : TestCase() {

    fun `test link to script error`() {
        val links = ConsoleLinkParser.parseText("At: res://paddle.gd:13.")
        assertContainsElements(links, ConsoleLink(4..21, "paddle.gd", 13))
    }

    fun `test link to image file with underscore and subdirectory`() {
        val links = ConsoleLinkParser.parseText("Loading resource: res://gfx/asteroid_2.png")
        assertContainsElements(links, ConsoleLink(18..41, "gfx/asteroid_2.png", 0))
    }

    fun `test link to script error without line`() {
        val links = ConsoleLinkParser.parseText("At: res://main.gd.")
        assertContainsElements(links, ConsoleLink(4..17, "main.gd"))
    }

    fun `test line with no links`() {
        val links = ConsoleLinkParser.parseText("ERROR: reload: Method failed. Returning: ERR_PARSE_ERROR")
        assertEmpty(links)
    }

    fun `test link to missing import file`() {
        val links = ConsoleLinkParser.parseText("ERROR: _load: Failed loading resource: res://.import/speaker.png-045bf6684b83b55b088824f14e175d16.stex.")
        assertContainsElements(links, ConsoleLink(39..102, ".import/speaker.png-045bf6684b83b55b088824f14e175d16.stex"))
    }

    fun `test two links at once`() {
        val links = ConsoleLinkParser.parseText("ERROR: poll: res://main.tscn:5 - Parse Error: [ext_resource] referenced nonexistent resource at: res://speaker.png")
        assertContainsElements(links, ConsoleLink(13..29, "main.tscn", 5))
        assertContainsElements(links, ConsoleLink(97..113, "speaker.png"))
    }

}
