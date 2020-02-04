package scene

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider

class ResourceFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ResourceLanguage) {

    override fun getFileType() = ResourceType

}
