package plugin.psi

import com.intellij.psi.PsiElement

class VariableReference(element: IdentifierPsiINode) : GDScriptElementReference(element) {

    override fun isDefSubtree(def: PsiElement) = def is VardefSubtree

}
