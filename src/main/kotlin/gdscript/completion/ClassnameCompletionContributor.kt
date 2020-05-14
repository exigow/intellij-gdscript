package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.util.PsiTreeUtil
import gdscript.completion.utils.LookupFactory
import net.pearx.kasechange.toPascalCase

class ClassnameCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (PsiTreeUtil.prevVisibleLeaf(element)?.text == "class_name") {
            val filename = getFilename(parameters)
            val lookup = LookupFactory.createClassname(filename)
            result.caseInsensitive().addElement(lookup)
        }
    }

    private fun getFilename(params: CompletionParameters) = params
        .originalFile
        .virtualFile
        .nameWithoutExtension
        .toPascalCase()

}
