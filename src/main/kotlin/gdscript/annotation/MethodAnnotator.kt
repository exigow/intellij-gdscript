package gdscript.annotation

import ScriptLexer.IDENTIFIER
import ScriptParser.RULE_func_line
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.options.ColorTextAttributeKey.INSTANCE_METHOD
import gdscript.utilities.PsiElementUtils.token
import gdscript.utilities.PsiElementUtils.rule
class MethodAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val isIdentifier = element.token() == IDENTIFIER
        val isInsideFunc = element.parent.rule() == RULE_func_line
        if (isIdentifier && isInsideFunc)
            holder.createColorAnnotation(element, INSTANCE_METHOD)
    }

}