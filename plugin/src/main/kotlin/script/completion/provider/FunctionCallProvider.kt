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

object FunctionCallProvider : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        for (method in GodotApi.LANGUAGE_CLASS.methods)
            result.addElement(withPriority(createBuiltInMethodLookup(method), Priority.FUNCTION_CALL))
    }

    private fun createBuiltInMethodLookup(method: GodotApi.Class.Method) = create(method.name)
        .withIcon(PlatformIcons.FUNCTION_ICON)
        .withItemTextItalic(true)
        .withTailText(method.joinedArguments())
        .withTypeText(method.type)
        .withInsertHandler { ctx, _ ->
            if (ctx.hasNoOpenBraceAfterCaret()) {
                ctx.insert("()")
                if (method.arguments.isEmpty())
                    ctx.moveCaret(2)
                else
                    ctx.moveCaret(1)
            }
        }

    private fun GodotApi.Class.Method.joinedArguments() =
        arguments.joinToString(", ", "(", ")") { "${it.name}: ${it.type}" }

}
