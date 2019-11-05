package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import gdscript.completion.sources.CompletionUtils
import gdscript.psi.InvokeRule


class InvokeCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (parameters.position.parent is InvokeRule)
            result.caseInsensitive()
                .addAllElements(ALL_NAMES)
    }

    companion object {

        private val FUNCTION_NAMES =
            CompletionUtils.functions().map { it.name }
        private val CLASS_CONSTRUCTORS =
            CompletionUtils.classConstructors().map { it.name }
        private val PRIMITIVE_CONSTRUCTORS =
            CompletionUtils.primitiveConstructors().map { it.name }

        private val ALL_NAMES = listOf(FUNCTION_NAMES, CLASS_CONSTRUCTORS, PRIMITIVE_CONSTRUCTORS)
            .flatten()
            .map { create(it) }

    }

}
