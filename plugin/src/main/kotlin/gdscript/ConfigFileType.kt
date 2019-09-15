package gdscript

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import gdscript.languages.ConfigLanguage

object ConfigFileType : LanguageFileType(ConfigLanguage) {

    override fun getName() = "Import"

    override fun getDescription() = "Godot Import file"

    override fun getDefaultExtension() = "import"

    override fun getIcon() = IconLoader.getIcon("/file_icon.png") // todo change icon

}
