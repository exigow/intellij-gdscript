package gdscript.completion

import ScriptParser.IDENTIFIER
import ScriptParser.RULE_class_name_line
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import gdscript.lang.psi.PsiElementUtils.rule
import gdscript.lang.psi.PsiElementUtils.token
import net.pearx.kasechange.toPascalCase

class ClassNameCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val isInsideClassName = parameters.position.parent.rule() == RULE_class_name_line
        val isIdentifier = parameters.position.token() == IDENTIFIER
        if (isInsideClassName && isIdentifier) {
            val file = parameters.originalFile.virtualFile
            val name = file.nameWithoutExtension.toPascalCase()
            result.caseInsensitive()
                .addElement(create(name))
        }
    }

}
