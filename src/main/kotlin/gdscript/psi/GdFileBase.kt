package gdscript.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import gdscript.GdLanguage
import gdscript.GdFileType
import gdscript.icons.GdIcons
import org.antlr.intellij.adaptor.psi.ScopeNode

class GdFileBase(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, GdLanguage) {

    override fun getFileType() = GdFileType

    override fun getIcon(flags: Int) = GdIcons.FILE_ICON

    override fun getContext(): ScopeNode? = null

}
