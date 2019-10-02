package config

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader

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
