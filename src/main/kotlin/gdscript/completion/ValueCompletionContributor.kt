package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.CaseSensitiveLookupProvider
import gdscript.completion.utils.CommonPatterns.WITH_INVOKE_PARENT
import gdscript.completion.utils.CommonPatterns.WITH_VALUE_PARENT
import gdscript.completion.utils.LookupElementBuilderUtils.withArgumentsTail
import gdscript.completion.utils.LookupElementBuilderUtils.withParenthesesInsertHandler
import gdscript.icons.IconCatalog
import gdscript.icons.IconCatalog.STATIC_CLASS
import gdscript.icons.IconCatalog.STATIC_VARIABLE
import gdscript.psi.InvokeRule
import gdscript.psi.ValueRule


class ValueCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, WITH_VALUE_PARENT, CaseSensitiveLookupProvider(SINGLETON_NAMES))
        extend(BASIC, WITH_VALUE_PARENT, CaseSensitiveLookupProvider(CONSTANT_VALUES))
        extend(BASIC, WITH_VALUE_PARENT, CaseSensitiveLookupProvider(FUNCTIONS))
        extend(BASIC, WITH_VALUE_PARENT, CaseSensitiveLookupProvider(CLASS_CONSTRUCTORS))
        extend(BASIC, WITH_VALUE_PARENT, CaseSensitiveLookupProvider(PRIMITIVE_CONSTRUCTORS))
        extend(BASIC, WITH_VALUE_PARENT, CaseSensitiveLookupProvider(KEYWORD_VARIABLES))
        extend(BASIC, WITH_INVOKE_PARENT, CaseSensitiveLookupProvider(PRIMITIVE_CONSTRUCTORS))
        extend(BASIC, WITH_INVOKE_PARENT, CaseSensitiveLookupProvider(FUNCTIONS))
        extend(BASIC, WITH_INVOKE_PARENT, CaseSensitiveLookupProvider(CLASS_CONSTRUCTORS))
    }

    companion object Lookups {

        private val KEYWORD_VARIABLES =
            CompletionUtils.keywordVariables()
                .map { create(it).bold() }

        private val SINGLETON_NAMES =
            CompletionUtils.singletons()
                .map { create(it.name).withIcon(STATIC_CLASS) }

        private val CONSTANT_VALUES =
            CompletionUtils.constants()
                .map {
                    create(it.name)
                        .withIcon(STATIC_VARIABLE)
                        .withTailText(" = ${it.value}")
                }

        private val FUNCTIONS =
            CompletionUtils.functions()
                .map {
                    create(it.name)
                        .withIcon(IconCatalog.FUNCTION)
                        .withTypeText(it.type)
                        .withArgumentsTail(it.arguments)
                        .withParenthesesInsertHandler(it.arguments.isNotEmpty())
                        .bold()
                }

        private val CLASS_CONSTRUCTORS =
            CompletionUtils.classConstructors()
                .map {
                    create(it.name)
                        .withIcon(IconCatalog.CLASS)
                        .withArgumentsTail(it.arguments)
                        .withParenthesesInsertHandler(it.arguments.isNotEmpty())
                }

        private val PRIMITIVE_CONSTRUCTORS =
            CompletionUtils.primitiveConstructors()
                .map {
                    create(it.name)
                        .withArgumentsTail(it.arguments)
                        .withParenthesesInsertHandler(it.arguments.isNotEmpty())
                        .bold()
                }

    }

}
