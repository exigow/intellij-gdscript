package gdscript.file

import com.intellij.openapi.fileTypes.LanguageFileType
import gdscript.icons.IconCatalog
import gdscript.parser.ScriptLanguage

object ScriptType : LanguageFileType(ScriptLanguage) {

    override fun getIcon() = IconCatalog.GODOT_FILE

    override fun getName() = "GDScript"

    override fun getDefaultExtension() = "gd"

    override fun getDescription() = "GDScript source file"

}
