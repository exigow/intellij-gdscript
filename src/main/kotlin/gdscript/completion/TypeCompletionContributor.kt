package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.CaseInsensitiveLookupProvider
import gdscript.icons.IconCatalog.CLASS
import gdscript.psi.TypeRule


class TypeCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, WITH_TYPE_PARENT, CaseInsensitiveLookupProvider(PRIMITIVES))
        extend(BASIC, WITH_TYPE_PARENT, CaseInsensitiveLookupProvider(CLASSES))
    }

    private companion object {

        val WITH_TYPE_PARENT =
            psiElement().withParent(TypeRule::class.java)!!

        val PRIMITIVES =
            CompletionUtils.primitives()
                .map { create(it.name).bold() }

        val CLASSES =
            CompletionUtils.classes()
                .map { create(it.name).withTypeText(it.extends).withIcon(CLASS) }

    }

}
