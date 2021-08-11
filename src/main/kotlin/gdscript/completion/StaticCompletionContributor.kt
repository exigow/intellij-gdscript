package gdscript.completion

import version.VersionService
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.components.service
import com.intellij.psi.util.PsiTreeUtil
import gdscript.ScriptTokenType
import gdscript.completion.utils.LookupFactory
import gdscript.utils.PsiElementUtils.isLeaf

class StaticCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val prev = PsiTreeUtil.prevVisibleLeaf(parameters.position)
        if (prev?.isLeaf(ScriptTokenType.DOT) == true) {
            val id = PsiTreeUtil.prevVisibleLeaf(prev)
            val lookups = findClassLookups(id?.text.orEmpty())
            result.caseInsensitive().addAllElements(lookups)
        }
    }

    private fun findClassLookups(name: String): List<LookupElement> {
        val api = VersionService.current()
        val clazz = (api.classes + api.singletons).find { it.name == name }
            ?: return emptyList()
        val constants = clazz.constants.map { LookupFactory.createConstant(it) }
        if (clazz !in api.singletons)
            return constants
        val methods = clazz.methods.map { LookupFactory.createStaticMethod(it) }
        return constants + methods
    }

}
