package gdscript.completion.lookups

import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons
import gdscript.completion.sources.Argument
import gdscript.completion.sources.Method

object InvokeLookups {

    fun createConstructor(it: Method): LookupElement =
        create(it.name)
            .withIcon(PlatformIcons.CLASS_ICON)
            .withTypeText(it.type)
            .withArgumentsTail(it.arguments)
            .withParenthesesInsertHandler(it.arguments.isNotEmpty())

    fun createFunction(it: Method): LookupElement =
        create(it.name)
            .withIcon(PlatformIcons.FUNCTION_ICON)
            .withTypeText(it.type)
            .withArgumentsTail(it.arguments)
            .withParenthesesInsertHandler(it.arguments.isNotEmpty())
            .bold()

    private fun LookupElementBuilder.withArgumentsTail(arguments: List<Argument>) =
        withTailText(arguments.joinToString(", ", "(", ")") { "${it.name}: ${it.type}" })

    private fun LookupElementBuilder.withParenthesesInsertHandler(hasParameters: Boolean): LookupElementBuilder =
        if (hasParameters)
            withInsertHandler(ParenthesesInsertHandler.WITH_PARAMETERS)
        else
            withInsertHandler(ParenthesesInsertHandler.NO_PARAMETERS)

}