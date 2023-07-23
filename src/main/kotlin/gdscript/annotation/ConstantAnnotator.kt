package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import gdscript.Colors
import gdscript.psi.ScriptElementTypes.IDENTIFIER
import version.VersionService

class ConstantAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.elementType == IDENTIFIER && isConstant(element.text))
            holder.createTextAttributesAnnotation(element, Colors.CONSTANT.key)
    }

    private fun isConstant(name: String) =
        CONSTANT_REGEX.matches(name) || isGlobalConstant(name)

    private fun isGlobalConstant(name: String) =
        VersionService.current().globals
            .flatMap { it.constants }
            .any { name == it.name }

    private companion object {

        private val CONSTANT_REGEX = "[A-Z][A-Z0-9_]+".toRegex()

    }

}
