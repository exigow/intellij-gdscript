package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import common.Colors.INSTANCE_METHOD
import common.PsiElementUtils.hasParent
import common.PsiElementUtils.isToken
import gdscript.ScriptLexer.IDENTIFIER
import gdscript.ScriptParser.RULE_func_line

class MethodAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isToken(IDENTIFIER) && element.hasParent(RULE_func_line))
            holder.colorize(element, INSTANCE_METHOD)
    }

}