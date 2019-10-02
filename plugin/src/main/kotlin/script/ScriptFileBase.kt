package script

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import org.antlr.intellij.adaptor.psi.ScopeNode

class ScriptFileBase(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ScriptLanguage) {

    override fun getFileType() = ScriptFileType

    override fun getIcon(flags: Int) = ScriptFileType.icon

    override fun getContext(): ScopeNode? = null

}
