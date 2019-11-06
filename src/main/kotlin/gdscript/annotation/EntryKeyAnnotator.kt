package gdscript.annotation

import ScriptParser.RULE_entry_key
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.options.ColorTextAttributeKey.INSTANCE_FIELD
import gdscript.utilities.PsiElementUtils.rule

class EntryKeyAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.rule() == RULE_entry_key)
            holder.createColorAnnotation(element, INSTANCE_FIELD)
    }

}