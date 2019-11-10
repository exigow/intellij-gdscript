package gdscript.completion

import ScriptParser.RULE_primary
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.psi.PsiElement
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.LookupElementBuilderUtils.withArgumentsTail
import gdscript.completion.utils.LookupElementBuilderUtils.withParenthesesInsertHandler
import gdscript.lang.IconCatalog
import gdscript.lang.IconCatalog.STATIC_CLASS
import gdscript.lang.IconCatalog.STATIC_VARIABLE
import gdscript.lang.psi.PsiElementUtils.rule

class PrimaryCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        val isInsideParent = element.parent.rule() == RULE_primary
        if (isInsideParent && hasNotDigitPrefix(element)) {
            val all = listOf(
                SINGLETON_NAMES,
                CONSTANT_VALUES,
                FUNCTIONS,
                CLASS_CONSTRUCTORS,
                PRIMITIVE_CONSTRUCTORS,
                KEYWORD_VARIABLES
            )
            result.addAllElements(all.flatten())
        }
    }

    private fun hasNotDigitPrefix(element: PsiElement) =
        !element.text.first().isDigit()

    companion object {

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
