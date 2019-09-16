package gdscript

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import gdscript.languages.ConfigLanguage

object ConfigFileType : LanguageFileType(ConfigLanguage) {

    override fun getIcon() =
        IconLoader.getIcon("/file_icon.png")

    override fun getName() =
        ConfigLanguage.displayName

    override fun getDefaultExtension() =
        "cfg"

    override fun getDescription() =
        "${ConfigLanguage.displayName} file"
}
