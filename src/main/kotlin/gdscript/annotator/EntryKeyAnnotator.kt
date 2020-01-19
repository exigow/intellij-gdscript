package gdscript.annotator

import ScriptParser.RULE_entry_key
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.colorSettingsPage.ColorTextAttributeKey.INSTANCE_FIELD
import gdscript.lang.psi.PsiElementUtils.isRule

class EntryKeyAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isRule(RULE_entry_key))
            holder.colorize(element, INSTANCE_FIELD)
    }

}