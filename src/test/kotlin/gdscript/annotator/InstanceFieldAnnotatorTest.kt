package gdscript.annotator

import gdscript.BaseTest
import uitlities.highlightedTexts
import uitlities.openCode

class InstanceFieldAnnotatorTest : BaseTest() {

    fun `test field`() {
        environment.openCode("hero.left_hand")
        assertTrue("left_hand" in environment.highlightedTexts())
    }

    fun `test field of field`() {
        environment.openCode("hero.left_hand.item")
        assertTrue("left_hand" in environment.highlightedTexts())
        assertTrue("item" in environment.highlightedTexts())
    }

}