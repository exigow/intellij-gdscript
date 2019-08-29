package gdscript.psi

import com.intellij.psi.FileViewProvider
import gdscript.GDScriptLanguage
import gdscript.LanguageFileType
import gdscript.icons.Icons
import org.antlr.intellij.adaptor.psi.ScopeNode

class PsiFileBase(viewProvider: FileViewProvider) : com.intellij.extapi.psi.PsiFileBase(viewProvider, GDScriptLanguage) {

    override fun getFileType() = LanguageFileType

    override fun getIcon(flags: Int) = Icons.FILE_ICON

    override fun getContext(): ScopeNode? = null

}
