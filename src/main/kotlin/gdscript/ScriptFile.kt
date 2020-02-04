package gdscript

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider

class ScriptFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ScriptLanguage) {

    override fun getFileType() = ScriptType

}
