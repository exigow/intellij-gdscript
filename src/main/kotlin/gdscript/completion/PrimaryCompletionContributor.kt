package gdscript.completion

import version.VersionService
import version.data.Class
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.components.service
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import gdscript.ScriptTokenType.DOT
import gdscript.ScriptTokenType.NUMBER
import gdscript.completion.utils.LookupFactory
import gdscript.lexer.ScriptKeywords
import gdscript.utils.PsiElementUtils.isLeaf
import gdscript.utils.PsiElementUtils.isStringLeaf

class PrimaryCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (isNotAfterDot(element) && !element.isStringLeaf() && hasNotDigitPrefix(parameters))
            result.addAllElements(collectLookups())
    }

    private fun isNotAfterDot(element: PsiElement): Boolean {
        val prev = PsiTreeUtil.prevVisibleLeaf(element)
            ?: return true
        return !prev.isLeaf(DOT)
    }

    private fun hasNotDigitPrefix(parameters: CompletionParameters): Boolean {
        val elementBeforeOffset = parameters.position.containingFile.findElementAt(parameters.offset - 1)!!
        return !elementBeforeOffset.isLeaf(NUMBER)
    }

    private fun collectLookups(): List<LookupElement> {
        val api = VersionService.current()
        val constants = api.globals.flatMap { it.constants }.map { LookupFactory.createConstant(it) }
        val functions = api.globals.flatMap { it.methods }.map { LookupFactory.createFunction(it) }
        val singletons = api.singletons.map { LookupFactory.createSingleton(it) }
        val constructors = filterConstructors(api.classes).map { LookupFactory.createConstructor(it) }
        val primitiveConstructors = filterConstructors(api.primitives).map { LookupFactory.createPrimitiveConstructor(it) }
        val keywords = ScriptKeywords.VALUES.map { LookupFactory.createKeyword(it) }
        return constants + functions + singletons + constructors + primitiveConstructors + keywords
    }

    private fun filterConstructors(e: List<Class>) =
        e.flatMap { c -> c.methods.filter { c.name == it.name } }

}
