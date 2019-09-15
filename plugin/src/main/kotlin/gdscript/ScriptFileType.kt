package gdscript

import com.intellij.openapi.util.IconLoader
import gdscript.adaptors.LanguageFileTypeAdaptor
import gdscript.languages.ScriptLanguage

object ScriptFileType : LanguageFileTypeAdaptor(
    adaptedLanguage = ScriptLanguage,
    extension = "gd",
    adaptedIcon = IconLoader.getIcon("/file_icon.png")
)
