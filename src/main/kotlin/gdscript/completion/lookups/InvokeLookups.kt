package gdscript.completion.lookups

import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import gdscript.completion.sources.Argument
import gdscript.completion.sources.Method
import gdscript.icons.IconCatalog

object InvokeLookups {

    fun createConstructor(it: Method): LookupElement =
        create(it.name)
            .withIcon(IconCatalog.CLASS)
            .withArgumentsTail(it.arguments)
            .withParenthesesInsertHandler(it.arguments.isNotEmpty())

    fun createStaticMethod(it: Method): LookupElement =
        create(it.name)
            .withIcon(IconCatalog.STATIC_METHOD)
            .withArgumentsTail(it.arguments)
            .withParenthesesInsertHandler(it.arguments.isNotEmpty())
            .withTypeText(it.type)
            .bold()

    fun createPrimitiveConstructor(it: Method): LookupElement =
        create(it.name)
            .withArgumentsTail(it.arguments)
            .withParenthesesInsertHandler(it.arguments.isNotEmpty())
            .bold()

    fun createFunction(it: Method): LookupElement =
        create(it.name)
            .withIcon(IconCatalog.FUNCTION)
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