package gdscript.completion

import gdscript.completion.sources.COMPLETION_DATA
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.patterns.PlatformPatterns.psiElement
import gdscript.completion.lookups.ConstantLookups.createConstant
import gdscript.completion.lookups.ConstantLookups.createSingleton
import gdscript.completion.lookups.InvokeLookups.createConstructor
import gdscript.completion.lookups.InvokeLookups.createFunction
import gdscript.completion.lookups.InvokeLookups.createPrimitiveConstructor
import gdscript.completion.lookups.KeywordLookups.createKeyword
import gdscript.completion.providers.CaseSensitiveLookupProvider
import gdscript.psi.InvokeRule
import gdscript.psi.ValueRule


class ValueCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, INSIDE_VALUE, CaseSensitiveLookupProvider(SINGLETONS))
        extend(BASIC, INSIDE_VALUE, CaseSensitiveLookupProvider(CONSTANTS))
        extend(BASIC, INSIDE_VALUE, CaseSensitiveLookupProvider(FUNCTIONS))
        extend(BASIC, INSIDE_VALUE, CaseSensitiveLookupProvider(CLASSES))
        extend(BASIC, INSIDE_VALUE, CaseSensitiveLookupProvider(PRIMITIVES))
        extend(BASIC, INSIDE_VALUE, CaseSensitiveLookupProvider(KEYWORDS))
        extend(BASIC, INSIDE_INVOKE, CaseSensitiveLookupProvider(PRIMITIVES))
        extend(BASIC, INSIDE_INVOKE, CaseSensitiveLookupProvider(FUNCTIONS))
        extend(BASIC, INSIDE_INVOKE, CaseSensitiveLookupProvider(CLASSES))
    }

    companion object {
        private val INSIDE_VALUE = psiElement()
            .withParent(ValueRule::class.java)
            .andNot(psiElement().afterLeaf(".")).andNot(psiElement().beforeLeaf("."))
        private val INSIDE_INVOKE = psiElement()
            .withParent(InvokeRule::class.java)
        private val KEYWORDS = listOf("self", "true", "false", "null")
            .map { createKeyword(it) }
        private val SINGLETONS = COMPLETION_DATA.singletons
            .map { createSingleton(it.name, it.type) }
        private val CONSTANTS = COMPLETION_DATA.constants
            .map { createConstant(it.name, it.value) }
        private val FUNCTIONS = COMPLETION_DATA.functions
            .map { createFunction(it) }
        private val CLASSES = COMPLETION_DATA.classes
            .flatMap { clazz -> clazz.methods.filter { it.name == clazz.name } }
            .map { createConstructor(it) }
        private val PRIMITIVES = COMPLETION_DATA.primitiveClasses
            .flatMap { clazz -> clazz.methods.filter { it.name == clazz.name } }
            .map { createPrimitiveConstructor(it) }
    }

}
