package gdscript.completion.lookups

import GodotApi
import com.intellij.codeInsight.completion.AddSpaceInsertHandler
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler
import com.intellij.codeInsight.lookup.LookupElementBuilder

internal fun LookupElementBuilder.italics() =
    withItemTextItalic(true)

internal fun LookupElementBuilder.withArgumentsTail(arguments: List<GodotApi.Class.Method.Argument>) =
    withTailText(arguments.joinToString(", ", "(", ")") { "${it.name}: ${it.type}" })

internal fun LookupElementBuilder.withParenthesesInsertHandler(hasParameters: Boolean): LookupElementBuilder =
    if (hasParameters)
        withInsertHandler(ParenthesesInsertHandler.WITH_PARAMETERS)
    else
        withInsertHandler(ParenthesesInsertHandler.NO_PARAMETERS)

internal fun LookupElementBuilder.withSpaceInsertHandler(): LookupElementBuilder =
    withInsertHandler(AddSpaceInsertHandler.INSTANCE_WITH_AUTO_POPUP)