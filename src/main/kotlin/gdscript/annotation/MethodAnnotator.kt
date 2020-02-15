package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import common.Colors.INSTANCE_METHOD
import common.PsiElementUtils.hasAncestors
import common.PsiElementUtils.isToken
import gdscript.ScriptLexer.IDENTIFIER
import gdscript.ScriptParser.RULE_funcLine
import gdscript.ScriptParser.RULE_id

class MethodAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isToken(IDENTIFIER) && element.hasAncestors(RULE_id, RULE_funcLine))
            holder.colorize(element, INSTANCE_METHOD)
    }

}