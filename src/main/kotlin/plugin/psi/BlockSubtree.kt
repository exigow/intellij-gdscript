package plugin.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.intellij.adaptor.psi.ScopeNode
import plugin.GDScriptLanguage

class BlockSubtree(node: ASTNode) : ANTLRPsiNode(node), ScopeNode {

    override fun resolve(element: PsiNamedElement): PsiElement? {
        return SymtabUtils.resolve(this, GDScriptLanguage, element, "/block/vardef/ID")
    }

}
