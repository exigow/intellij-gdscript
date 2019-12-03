package gdscript.annotator

import ScriptParser.RULE_entry_key
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.colorSettingsPage.ColorTextAttributeKey
import gdscript.lang.psi.PsiElementUtils.rule

class EntryKeyAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.rule() == RULE_entry_key)
            holder.colorize(element, ColorTextAttributeKey.INSTANCE_FIELD)
    }

}