package gdscript

import com.intellij.openapi.util.IconLoader
import gdscript.adaptors.LanguageFileTypeAdaptor
import gdscript.languages.ConfigLanguage

object ConfigFileType : LanguageFileTypeAdaptor(
    adaptedLanguage = ConfigLanguage,
    extension = "import",
    adaptedIcon = IconLoader.getIcon("/file_icon.png")
)
