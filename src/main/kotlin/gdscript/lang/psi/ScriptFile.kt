package gdscript.lang.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import gdscript.fileType.ScriptType
import gdscript.lang.ScriptLanguage

class ScriptFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ScriptLanguage) {

    override fun getFileType() = ScriptType

}
