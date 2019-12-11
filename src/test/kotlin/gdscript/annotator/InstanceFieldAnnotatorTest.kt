package gdscript.annotator

import gdscript.BaseTest
import uitlities.highlights
import uitlities.openScript

class InstanceFieldAnnotatorTest : BaseTest() {

    fun `test highlight instance field`() {
        environment.openScript("hero.left_hand")
        assertContainsElements(environment.highlights(), "left_hand")
    }

    fun `test highlight instance field of instance field`() {
        environment.openScript("hero.left_hand.item")
        assertContainsElements(environment.highlights(), "left_hand", "item")
    }

}