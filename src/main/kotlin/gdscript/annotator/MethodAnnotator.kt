package gdscript.annotator

import ScriptLexer.IDENTIFIER
import ScriptParser.RULE_func_line
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.colorSettingsPage.ColorTextAttributeKey
import gdscript.lang.psi.PsiElementUtils.rule
import gdscript.lang.psi.PsiElementUtils.token

class MethodAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val isIdentifier = element.token() == IDENTIFIER
        val isInsideFunc = element.parent.rule() == RULE_func_line
        if (isIdentifier && isInsideFunc)
            holder.colorize(element, ColorTextAttributeKey.INSTANCE_METHOD)
    }

}