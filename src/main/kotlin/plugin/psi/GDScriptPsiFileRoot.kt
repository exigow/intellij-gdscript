package plugin.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.ScopeNode
import plugin.GDScriptFileType
import plugin.GDScript
import plugin.Icons

class GDScriptPsiFileRoot(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, GDScript), ScopeNode {

    override fun getFileType() = GDScriptFileType.INSTANCE

    override fun getIcon(flags: Int) = Icons.GDSCRIPT_ICON

    override fun getContext(): ScopeNode? = null

    override fun resolve(element: PsiNamedElement): PsiElement? {
        return if (element.parent is CallSubtree)
            SymtabUtils.resolve(this, GDScript, element, "/script/function/IDENTIFIER")
        else
            SymtabUtils.resolve(this, GDScript, element, "/script/vardef/IDENTIFIER")
    }

}
