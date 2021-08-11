package tscn.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.*
import tscn.TscnFileType
import tscn.TscnLanguage

class TscnFile(view: FileViewProvider) : PsiFileBase(view, TscnLanguage) {

    override fun getFileType() = TscnFileType

}