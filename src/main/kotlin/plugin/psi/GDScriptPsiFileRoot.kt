package plugin.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import org.antlr.intellij.adaptor.psi.ScopeNode
import plugin.GDScript
import plugin.GDScriptFileType
import plugin.Icons

class GDScriptPsiFileRoot(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, GDScript) {

    override fun getFileType() = GDScriptFileType.INSTANCE

    override fun getIcon(flags: Int) = Icons.GDSCRIPT_ICON

    override fun getContext(): ScopeNode? = null

}
