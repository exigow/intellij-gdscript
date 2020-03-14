package gdscript.execution.filters

import com.intellij.testFramework.UsefulTestCase.assertContainsElements
import com.intellij.testFramework.UsefulTestCase.assertEmpty
import gdscript.execution.filters.LinkParser.Link
import junit.framework.TestCase


class LinkParserTest : TestCase() {

    fun `test link to script error`() {
        val links = LinkParser.parseAll("At: res://paddle.gd:13.")
        assertContainsElements(links, Link(4..21, "paddle.gd", 13))
    }

    fun `test link to script error without line`() {
        val links = LinkParser.parseAll("At: res://main.gd.")
        assertContainsElements(links, Link(4..17, "main.gd"))
    }

    fun `test line with no links`() {
        val links = LinkParser.parseAll("ERROR: reload: Method failed. Returning: ERR_PARSE_ERROR")
        assertEmpty(links)
    }

    fun `test link to missing import file`() {
        val links = LinkParser.parseAll("ERROR: _load: Failed loading resource: res://.import/speaker.png-045bf6684b83b55b088824f14e175d16.stex.")
        assertContainsElements(links, Link(39..102, ".import/speaker.png-045bf6684b83b55b088824f14e175d16.stex"))
    }

    fun `test two links at once`() {
        val links = LinkParser.parseAll("ERROR: poll: res://main.tscn:5 - Parse Error: [ext_resource] referenced nonexistent resource at: res://speaker.png")
        assertContainsElements(links, Link(13..29, "main.tscn", 5))
        assertContainsElements(links, Link(97..113, "speaker.png"))
    }

}