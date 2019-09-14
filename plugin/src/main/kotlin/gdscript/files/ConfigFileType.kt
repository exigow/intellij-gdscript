package gdscript.files

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import gdscript.ConfigLanguage
import gdscript.ScriptLanguage

object ConfigFileType : LanguageFileType(ConfigLanguage) {

    override fun getName() = "Import"

    override fun getDescription() = "Godot Import file"

    override fun getDefaultExtension() = "import"

    override fun getIcon() = IconLoader.getIcon("/file_icon.png") // todo change icon

}
