package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.CaseInsensitiveLookupProvider
import gdscript.completion.utils.CommonPatterns.WITH_TYPE_PARENT
import gdscript.icons.IconCatalog.CLASS


class TypeCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, WITH_TYPE_PARENT, CaseInsensitiveLookupProvider(PRIMITIVE_NAMES))
        extend(BASIC, WITH_TYPE_PARENT, CaseInsensitiveLookupProvider(CLASS_NAMES))
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
