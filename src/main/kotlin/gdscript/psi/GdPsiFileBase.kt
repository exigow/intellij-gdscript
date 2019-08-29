package gdscript.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import org.antlr.intellij.adaptor.psi.ScopeNode
import gdscript.GdLanguage
import gdscript.GdLanguageFileType
import gdscript.icons.GdIcons

class GdPsiFileBase(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, GdLanguage) {

    override fun getFileType() = GdLanguageFileType

    override fun getIcon(flags: Int) = GdIcons.FILE_ICON

    override fun getContext(): ScopeNode? = null

}
