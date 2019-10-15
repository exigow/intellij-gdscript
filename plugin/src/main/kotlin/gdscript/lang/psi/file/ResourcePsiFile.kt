package gdscript.lang.psi.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import gdscript.files.ResourceFileType
import gdscript.lang.ResourceLanguage

class ResourcePsiFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ResourceLanguage) {

    override fun getFileType() = ResourceFileType

}
