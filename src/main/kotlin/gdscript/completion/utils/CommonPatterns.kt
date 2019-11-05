package gdscript.completion.utils

import com.intellij.patterns.PlatformPatterns.psiElement
import gdscript.psi.TypeRule

object CommonPatterns {

    val AFTER_NEWLINE =
        psiElement().afterLeaf("\n")

    val AFTER_EXPORT =
        psiElement().afterLeaf("export")

    val AFTER_STATIC =
        psiElement().afterLeaf("static")

    val WITH_TYPE_PARENT =
        psiElement().withParent(TypeRule::class.java)!!

}