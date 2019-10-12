package script.completion.provider

import GodotApi
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement.withPriority
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons
import com.intellij.util.ProcessingContext
import script.completion.Priority

object ConstructorCallProvider : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        val allClasses = GodotApi.OBJECT_CLASSES + GodotApi.PRIMITIVE_CLASSES
        for (clazz in allClasses) {
            val lookup = createConstructorCallLookup(clazz)
            val prioritized = withPriority(lookup, Priority.CONSTRUCTOR_CALL)
            result.addElement(prioritized)
        }
    }

    private fun createConstructorCallLookup(clazz: GodotApi.Class) = create(clazz.name)
        .withIcon(PlatformIcons.CLASS_ICON)
        .withTailText("()")
        .withTypeText(clazz.name)
        .withInsertHandler { ctx, _ ->
            if (ctx.hasNoOpenBraceAfterCaret()) {
                ctx.insert("()")
                ctx.moveCaret(2)
            }
        }

}
