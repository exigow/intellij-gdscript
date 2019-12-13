package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.util.PsiTreeUtil
import gdscript.completion.sources.Class
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.LookupFactory

class StaticCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val dot = parameters.position.prevLeaf()
        if (dot?.text == ".") {
            val id = dot.prevLeaf()
            val clazz = CompletionUtils.findClass(id?.text)
            if (clazz != null) {
                val constants = createConstantLookups(clazz)
                result.caseInsensitive().addAllElements(constants)
                if (clazz in CompletionUtils.singletons()) {
                    val staticMethods = createStaticMethodLookups(clazz)
                    result.caseInsensitive().addAllElements(staticMethods)
                }
            }
        }
    }

    private fun createConstantLookups(clazz: Class) =
        clazz.constants.map { LookupFactory.createConstant(it) }

    private fun createStaticMethodLookups(clazz: Class) =
        clazz.methods.map { LookupFactory.createStaticMethod(it) }

    private fun PsiElement.prevLeaf() =
        PsiTreeUtil.prevLeaf(this) as? LeafPsiElement

}
