package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import gdscript.Colors
import gdscript.psi.ScriptElementTypes.IDENTIFIER
import version.VersionService

class ClassnameAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.elementType == IDENTIFIER && isClass(element.text))
            holder.createTextAttributesAnnotation(element, Colors.CLASS_NAME.key)
    }

    private fun isClass(name: String): Boolean {
        val api = VersionService.current()
        val classes = api.singletons.toList() + api.classes.toList() - api.primitives
        return classes.any { it.name == name }
    }

}
