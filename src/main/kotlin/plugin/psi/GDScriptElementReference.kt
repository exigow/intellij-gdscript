package plugin.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReferenceBase
import org.antlr.intellij.adaptor.psi.ScopeNode

abstract class GDScriptElementReference(element: IdentifierPsiINode) : PsiReferenceBase<IdentifierPsiINode>(element, TextRange(0, element.text.length)) {

    override fun getVariants(): Array<Any?> = arrayOfNulls(0)

    override fun handleElementRename(newElementName: String): PsiElement {
        return myElement.setName(newElementName)
    }

    override fun resolve(): PsiElement? {
        val scope = myElement.context as ScopeNode? ?: return null
        return scope.resolve(myElement)
    }

    override fun isReferenceTo(def: PsiElement): Boolean {
        var def = def
        val refName = myElement.name
        //		System.out.println(getClass().getSimpleName()+".isReferenceTo("+refName+"->"+def.getText()+")");
        // sometimes def comes in pointing to IDENTIFIER node itself. depends on what you click on
        if (def is IdentifierPsiINode && isDefSubtree(def.getParent())) {
            def = def.getParent()
        }
        if (isDefSubtree(def)) {
            val id = (def as PsiNameIdentifierOwner).nameIdentifier
            val defName = id?.text
            return refName != null && defName != null && refName == defName
        }
        return false
    }

    abstract fun isDefSubtree(def: PsiElement): Boolean

}
