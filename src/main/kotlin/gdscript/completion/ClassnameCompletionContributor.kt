package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import gdscript.completion.utils.LookupFactory
import gdscript.psi.ScriptElementTypes.CLASS_NAME
import net.pearx.kasechange.toPascalCase

class ClassnameCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (isAfterClassName(parameters.position)) {
            val filename = parameters.originalFile.virtualFile.nameWithoutExtension
            val lookup = LookupFactory.createClassname(filename.toPascalCase())
            result.caseInsensitive().addElement(lookup)
        }
    }

    private fun isAfterClassName(element: PsiElement) =
        PsiTreeUtil.prevVisibleLeaf(element)?.elementType == CLASS_NAME

}
