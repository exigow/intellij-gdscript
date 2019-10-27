package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.options.ColorTextAttributeKey.INSTANCE_METHOD
import gdscript.options.ColorTextAttributeKey.STATIC_METHOD
import gdscript.psi.FunctionRule

class MethodAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val parent = element.parent
        if (element.isIdentifier() && parent is FunctionRule)
            if (parent.isStatic())
                holder.createColorAnnotation(element, STATIC_METHOD)
            else
                holder.createColorAnnotation(element, INSTANCE_METHOD)
    }

}