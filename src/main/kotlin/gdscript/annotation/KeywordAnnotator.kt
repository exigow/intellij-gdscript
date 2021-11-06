package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import gdscript.Colors
import gdscript.psi.ScriptElementTypes.IDENTIFIER
import version.VersionService

class KeywordAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.elementType == IDENTIFIER && isKeyword(element.text)) {
            holder.createTextAttributesAnnotation(element, Colors.KEYWORD.key)
        }
    }

    private fun isKeyword(name: String) =
        VersionService.current().globals
            .flatMap { it.methods }
            .any { it.name == name }

}