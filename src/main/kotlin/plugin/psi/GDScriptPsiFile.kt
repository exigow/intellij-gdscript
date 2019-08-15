package plugin.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import org.antlr.intellij.adaptor.psi.ScopeNode
import plugin.GDScript
import plugin.GDScriptFileType
import plugin.icons.GDScriptIconFactory

class GDScriptPsiFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, GDScript) {

    override fun getFileType() = GDScriptFileType

    override fun getIcon(flags: Int) = GDScriptIconFactory.createLogo()

    override fun getContext(): ScopeNode? = null

}
