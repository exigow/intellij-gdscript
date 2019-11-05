package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import gdscript.completion.sources.CompletionUtils
import gdscript.icons.IconCatalog.CLASS
import gdscript.psi.TypeRule


class TypeCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (parameters.position.parent is TypeRule) {
            val all = PRIMITIVE_NAMES + CLASS_NAMES
            result.caseInsensitive()
                .addAllElements(all)
        }
    }

    private companion object {

        private val PRIMITIVE_NAMES =
            CompletionUtils.primitives()
                .map { create(it.name).bold() }

        private val CLASS_NAMES =
            CompletionUtils.classes()
                .map { create(it.name).withTypeText(it.extends).withIcon(CLASS) }

    }

}
