package gdscript.completion

import ScriptParser.IDENTIFIER
import ScriptParser.RULE_class_name_line
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import gdscript.lang.psi.PsiElementUtils.rule
import gdscript.lang.psi.PsiElementUtils.token
import net.pearx.kasechange.toPascalCase

class ClassNameCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (isInsideClassName(element) && isIdentifier(element)) {
            val lookup = createFilenameLookup(parameters.originalFile)
            result.caseInsensitive().addElement(lookup)
        }
    }

    private fun isIdentifier(element: PsiElement) =
        element.token() == IDENTIFIER

    private fun isInsideClassName(element: PsiElement) =
        element.parent.rule() == RULE_class_name_line

    private fun createFilenameLookup(file: PsiFile): LookupElement {
        val virtual = file.virtualFile
        val name = virtual.nameWithoutExtension.toPascalCase()
        return create(name)
    }

}
