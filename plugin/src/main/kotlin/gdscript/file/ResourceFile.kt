package gdscript.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import gdscript.file.ResourceType
import gdscript.parser.ResourceLanguage

class ResourceFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ResourceLanguage) {

    override fun getFileType() = ResourceType

}
