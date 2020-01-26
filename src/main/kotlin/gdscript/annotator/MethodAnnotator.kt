package gdscript.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.ScriptLexer.IDENTIFIER
import gdscript.ScriptParser.RULE_func_line
import gdscript.colorSettingsPage.ColorTextAttributeKey.INSTANCE_METHOD
import gdscript.lang.psi.PsiElementUtils.hasParent
import gdscript.lang.psi.PsiElementUtils.isToken

class MethodAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isToken(IDENTIFIER) && element.hasParent(RULE_func_line))
            holder.colorize(element, INSTANCE_METHOD)
    }

}