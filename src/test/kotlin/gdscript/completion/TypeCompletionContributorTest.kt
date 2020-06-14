package gdscript.completion

import BaseTest
import utils.lookups
import utils.openScript

class TypeCompletionContributorTest : BaseTest() {

//    fun `test lower-case class name in type expression invokes class name`() {
//        environment.openScript("var p: vec<caret>")
//        environment.completeBasic()
//        assertContainsElements(environment.lookups(), "Vector2")
//    }
//
//    fun `test upper-case primitive name in type expression invokes primitive name`() {
//        environment.openScript("var p: Flo<caret>")
//        environment.completeBasic()
//        assertContainsElements(environment.lookups(), "float")
//    }
//
//    fun `test class type completion after "as" operator`() {
//        environment.openScript("anim as Animation<caret>")
//        environment.completeBasic()
//        assertContainsElements(environment.lookups(), "AnimationPlayer")
//    }
//
//    fun `test class type completion after "is" operator`() {
//        environment.openScript("p is Vec<caret>")
//        environment.completeBasic()
//        assertContainsElements(environment.lookups(), "Vector2")
//    }
//
//    fun `test class type completion after "extends" operator`() {
//        environment.openScript("extends No<caret>")
//        environment.completeBasic()
//        assertContainsElements(environment.lookups(), "Node")
//    }
//
//    fun `test class type completion in function argument`() {
//        environment.openScript("func draw_circle(center: <caret>):")
//        environment.completeBasic()
//        assertContainsElements(environment.lookups(), "Vector2")
//    }

    fun `test class type completion in function returned type`() {
        environment.openScript("func get_position() -> <caret>:")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "Vector2")
    }
//
//    fun `test primitive type completion in function returned type`() {
//        environment.openScript("func get_length() -> <caret>:")
//        environment.completeBasic()
//        assertContainsElements(environment.lookups(), "float")
//    }


}
