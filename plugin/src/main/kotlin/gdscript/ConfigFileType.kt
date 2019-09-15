package gdscript

import com.intellij.openapi.util.IconLoader
import gdscript.adaptors.LanguageFileTypeAdaptor
import gdscript.languages.ConfigLanguage

object ConfigFileType : LanguageFileTypeAdaptor(
    language = ConfigLanguage,
    name = ConfigLanguage.displayName,
    description = "${ConfigLanguage.displayName} file",
    extension = "cfg",
    icon = IconLoader.getIcon("/file_icon.png")
)
