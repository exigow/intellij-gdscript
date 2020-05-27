package tscn


import com.intellij.openapi.fileTypes.LanguageFileType
import common.Icons

object TscnFileType : LanguageFileType(TscnLanguage) {

    override fun getIcon() = Icons.TSCN_FILE

    override fun getName() = "TSCN"

    override fun getDefaultExtension() = "tres"

    override fun getDescription() = name

}