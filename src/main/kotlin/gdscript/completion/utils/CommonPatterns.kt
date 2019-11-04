package gdscript.completion.utils

import com.intellij.patterns.PlatformPatterns.psiElement
import gdscript.psi.InvokeRule
import gdscript.psi.TypeRule
import gdscript.psi.ValueRule

object CommonPatterns {

    val AFTER_NEWLINE =
        psiElement().afterLeaf("\n")

    val AFTER_EXPORT =
        psiElement().afterLeaf("export")

    val AFTER_STATIC =
        psiElement().afterLeaf("static")

    val WITH_TYPE_PARENT =
        psiElement().withParent(TypeRule::class.java)!!

    val WITH_VALUE_PARENT =
        psiElement().withParent(ValueRule::class.java)
            .andNot(psiElement().afterLeaf(".")).andNot(psiElement().beforeLeaf("."))

    val WITH_INVOKE_PARENT =
        psiElement().withParent(InvokeRule::class.java)!!

}