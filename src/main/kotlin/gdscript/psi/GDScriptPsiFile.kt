package gdscript.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import org.antlr.intellij.adaptor.psi.ScopeNode
import gdscript.GDScript
import gdscript.GDScriptFileType
import gdscript.icons.IconFactory

class GDScriptPsiFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, GDScript) {

    override fun getFileType() = GDScriptFileType

    override fun getIcon(flags: Int) = IconFactory.createPluginIcon()

    override fun getContext(): ScopeNode? = null

}
