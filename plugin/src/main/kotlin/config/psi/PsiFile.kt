package config.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import config.ConfigFileType
import config.ConfigLanguage
import org.antlr.intellij.adaptor.psi.ScopeNode

class PsiFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ConfigLanguage) {

    override fun getFileType() = ConfigFileType

    override fun getIcon(flags: Int) = ConfigFileType.icon

    override fun getContext(): ScopeNode? = null

}
