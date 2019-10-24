package gdscript.completion

import gdscript.completion.sources.CompletionData.OBJECT_CLASSES
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.patterns.PlatformPatterns.psiElement
import gdscript.completion.lookups.ConstantLookups.createClass
import gdscript.completion.lookups.KeywordLookups.createKeyword
import gdscript.completion.providers.CaseInsensitiveLookupProvider
import gdscript.psi.TypeRule


class TypeCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, psiElement().withParent(TypeRule::class.java), CaseInsensitiveLookupProvider(PRIMITIVES))
        extend(BASIC, psiElement().withParent(TypeRule::class.java), CaseInsensitiveLookupProvider(CLASSES))
    }

    private companion object {
        val PRIMITIVES = listOf("bool", "float", "void", "int")
            .map { createKeyword(it) }
        val CLASSES = OBJECT_CLASSES
            .map { createClass(it.name, it.extends) }
    }

}
