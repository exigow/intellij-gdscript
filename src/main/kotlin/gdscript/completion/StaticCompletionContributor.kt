package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import gdscript.completion.lookups.ConstantLookups.createConstant
import gdscript.completion.lookups.InvokeLookups.createStaticMethod
import gdscript.completion.sources.COMPLETION_DATA
import gdscript.completion.sources.Class
import gdscript.utilities.PsiLeafUtils.prevLeaf

class StaticCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val dot = parameters.position.prevLeaf()
        if (dot?.text == ".") {
            val id = dot.prevLeaf()
            val clazz = findClass(id?.text)
            if (clazz != null) {
                val constants = createConstantLookups(clazz)
                result.caseInsensitive().addAllElements(constants)
                if (clazz in COMPLETION_DATA.singletons)
                    result.caseInsensitive().addAllElements(createStaticMethodLookups(clazz))
            }
        }
    }

    private fun findClass(name: String?) = (COMPLETION_DATA.classes + COMPLETION_DATA.singletons)
        .find { it.name == name }

    private fun createConstantLookups(clazz: Class) = clazz
        .constants
        .map { createConstant(it.name, formatSpaces(it.value)) }

    private fun createStaticMethodLookups(clazz: Class) = clazz
        .methods
        .map { createStaticMethod(it) }

    private fun formatSpaces(value: String) = value
        .replace(" ", "")
        .replace(",", ", ")

}
