package gdscript.lang.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import gdscript.fileType.ResourceType
import gdscript.lang.ResourceLanguage

class ResourceFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ResourceLanguage) {

    override fun getFileType() = ResourceType

}
