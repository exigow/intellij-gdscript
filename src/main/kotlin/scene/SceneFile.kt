package scene

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider

class SceneFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, SceneLanguage) {

    override fun getFileType() = SceneFileType

}
