package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import gdscript.completion.sources.Class
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.LookupElementBuilderUtils.withArgumentsTail
import gdscript.completion.utils.LookupElementBuilderUtils.withParenthesesInsertHandler
import gdscript.icons.IconCatalog
import gdscript.icons.IconCatalog.STATIC_VARIABLE
import gdscript.utilities.PsiLeafUtils.prevLeaf

class StaticCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val dot = parameters.position.prevLeaf()
        if (dot?.text == ".") {
            val id = dot.prevLeaf()
            val clazz = CompletionUtils.findClass(id?.text)
            if (clazz != null) {
                val constants = createConstantLookups(clazz)
                result.caseInsensitive().addAllElements(constants)
                if (clazz in CompletionUtils.singletons())
                    result.caseInsensitive().addAllElements(createStaticMethodLookups(clazz))
            }
        }
    }

    private fun createConstantLookups(clazz: Class) = clazz
        .constants
        .map {
            create(it.name)
                .withIcon(STATIC_VARIABLE)
                .withTailText(" = ${formatSpaces(it.value)}")
        }

    private fun createStaticMethodLookups(clazz: Class) = clazz
        .methods
        .map {
            create(it.name)
                .withIcon(IconCatalog.STATIC_METHOD)
                .withArgumentsTail(it.arguments)
                .withParenthesesInsertHandler(it.arguments.isNotEmpty())
                .withTypeText(it.type)
                .bold()
        }

    private fun formatSpaces(value: String) = value
        .replace(" ", "")
        .replace(",", ", ")

}
