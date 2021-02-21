package gdscript.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import gdscript.ScriptFileType
import gdscript.ScriptLanguage

class ScriptFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ScriptLanguage) {

    override fun getFileType() = ScriptFileType

}