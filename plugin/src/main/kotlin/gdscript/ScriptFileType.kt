package gdscript

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import gdscript.languages.ScriptLanguage

object ScriptFileType : LanguageFileType(ScriptLanguage) {

    override fun getIcon() =
        IconLoader.getIcon("/file_icon.png")

    override fun getName() =
        ScriptLanguage.displayName

    override fun getDefaultExtension() =
        "gd"

    override fun getDescription() =
        "${ScriptLanguage.displayName} file"

}
