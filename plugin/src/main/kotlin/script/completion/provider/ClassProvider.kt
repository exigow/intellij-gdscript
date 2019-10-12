package script.completion.provider

import GodotApi
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons
import com.intellij.util.ProcessingContext

object ClassProvider : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        for (name in GodotApi.OBJECT_CLASSES.map { it.name })
            result.addElement(create(name).withIcon(PlatformIcons.CLASS_ICON).withCaseSensitivity(false))
    }

}
