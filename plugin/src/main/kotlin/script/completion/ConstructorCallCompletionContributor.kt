package script.completion

import GodotApi
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.completion.PrioritizedLookupElement.withPriority
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.PlatformIcons.CLASS_ICON
import com.intellij.util.ProcessingContext
import script.psi.elements.InvokePsiElement
import script.psi.elements.ValuePsiElement


class ConstructorCallCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, psiElement().inside(ValuePsiElement::class.java), ConstructorCallProvider)
        extend(BASIC, psiElement().inside(InvokePsiElement::class.java), ConstructorCallProvider)
    }

    private object ConstructorCallProvider : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            val allClasses = GodotApi.OBJECT_CLASSES + GodotApi.PRIMITIVE_CLASSES
            for (clazz in allClasses) {
                val lookup = createConstructorCallLookup(clazz)
                val prioritized = withPriority(lookup, CompletionPriority.CONSTRUCTOR_CALL)
                result.addElement(prioritized)
            }
        }

        private fun createConstructorCallLookup(clazz: GodotApi.Class) = create(clazz.name)
            .withIcon(CLASS_ICON)
            .withTailText("()")
            .withTypeText(clazz.name)
            .withInsertHandler { ctx, _ ->
                if (ctx.hasNoOpenBraceAfterCaret()) {
                    ctx.insert("()")
                    ctx.moveCaret(2)
                }
            }

    }

}
