package gdscript.completion.utils

import com.intellij.patterns.PlatformPatterns
import gdscript.psi.InvokeRule
import gdscript.psi.TypeRule
import gdscript.psi.ValueRule

object CommonPatterns {

    val AFTER_NEWLINE =
        PlatformPatterns.psiElement().afterLeaf("\n")

    val AFTER_EXPORT =
        PlatformPatterns.psiElement().afterLeaf("export")

    val AFTER_STATIC =
        PlatformPatterns.psiElement().afterLeaf("static")

    val WITH_TYPE_PARENT =
        PlatformPatterns.psiElement().withParent(TypeRule::class.java)!!

    val WITH_VALUE_PARENT =
        PlatformPatterns.psiElement().withParent(ValueRule::class.java)
            .andNot(PlatformPatterns.psiElement().afterLeaf(".")).andNot(PlatformPatterns.psiElement().beforeLeaf("."))

    val WITH_INVOKE_PARENT =
        PlatformPatterns.psiElement().withParent(InvokeRule::class.java)!!

}