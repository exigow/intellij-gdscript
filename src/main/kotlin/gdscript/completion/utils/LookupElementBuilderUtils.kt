package gdscript.completion.utils

import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler.NO_PARAMETERS
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler.WITH_PARAMETERS
import com.intellij.codeInsight.lookup.LookupElementBuilder
import gdscript.completion.sources.Argument

object LookupElementBuilderUtils {

    fun LookupElementBuilder.withArgumentsTail(arguments: List<Argument>): LookupElementBuilder {
        val formatted = arguments.joinToString(", ", "(", ")") {
            "${it.name}: ${it.type}"
        }
        return withTailText(formatted)
    }

    fun LookupElementBuilder.withParenthesesInsertHandler(hasParameters: Boolean): LookupElementBuilder =
        if (hasParameters)
            withInsertHandler(WITH_PARAMETERS)
        else
            withInsertHandler(NO_PARAMETERS)

}