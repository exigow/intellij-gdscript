package gdscript.files

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import gdscript.ScriptLanguage

object ScriptFileType : LanguageFileType(ScriptLanguage) {

    override fun getName() = "GDScript"

    override fun getDescription() = "Godot GDScript file"

    override fun getDefaultExtension() = "gd"

    override fun getIcon() = IconLoader.getIcon("/file_icon.png")

}
