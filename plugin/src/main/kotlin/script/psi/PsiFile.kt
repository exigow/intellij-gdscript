package script.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import script.ScriptFileType
import script.ScriptLanguage

class PsiFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ScriptLanguage) {

    override fun getFileType() = ScriptFileType

}
