package gdscript.lang.psi.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import gdscript.files.ScriptFileType
import gdscript.lang.ScriptLanguage

class ScriptPsiFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ScriptLanguage) {

    override fun getFileType() = ScriptFileType

}
