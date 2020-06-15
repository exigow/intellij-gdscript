package gdscript.completion

import classes.CompletionDictionary
import classes.model.Class
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.util.PsiTreeUtil
import gdscript.ScriptTokenType
import gdscript.completion.utils.LookupFactory
import gdscript.utils.PsiElementUtils.isLeaf

class StaticCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val prev = PsiTreeUtil.prevVisibleLeaf(parameters.position)
        if (prev?.isLeaf(ScriptTokenType.DOT) == true) {
            val id = PsiTreeUtil.prevVisibleLeaf(prev)
            val clazz = CompletionDictionary.ALL_CLASSES.find { it.name == id?.text }
            if (clazz != null) {
                val constants = createConstantLookups(clazz)
                result.caseInsensitive().addAllElements(constants)
                if (clazz in CompletionDictionary.SINGLETON_CLASSES) {
                    val staticMethods = createStaticMethodLookups(clazz)
                    result.caseInsensitive().addAllElements(staticMethods)
                }
            }
        }
    }

    private fun createConstantLookups(clazz: Class) =
        clazz.constants?.map { LookupFactory.createConstant(it) }.orEmpty()

    private fun createStaticMethodLookups(clazz: Class) =
        clazz.methods?.map { LookupFactory.createStaticMethod(it) }.orEmpty()

}
