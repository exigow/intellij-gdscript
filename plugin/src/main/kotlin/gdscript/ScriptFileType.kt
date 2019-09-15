package gdscript

import com.intellij.openapi.util.IconLoader
import gdscript.adaptors.LanguageFileTypeAdaptor
import gdscript.languages.ScriptLanguage

object ScriptFileType : LanguageFileTypeAdaptor(
    language = ScriptLanguage,
    name = ScriptLanguage.displayName,
    description = "${ScriptLanguage.displayName} file",
    extension = "gd",
    icon = IconLoader.getIcon("/file_icon.png")
)
