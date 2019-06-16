package plugin.psi

import com.intellij.psi.PsiElement

class VariableRef(element: IdentifierPsiINode) : GDScriptElementRef(element) {

    override fun isDefSubtree(def: PsiElement) = def is VardefSubtree

}
