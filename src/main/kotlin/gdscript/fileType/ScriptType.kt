package gdscript.fileType

import com.intellij.openapi.fileTypes.LanguageFileType
import gdscript.lang.IconCatalog
import gdscript.lang.ScriptLanguage

object ScriptType : LanguageFileType(ScriptLanguage) {

    override fun getIcon() = IconCatalog.GODOT_FILE

    override fun getName() = "GDScript"

    override fun getDefaultExtension() = "gd"

    override fun getDescription() = "GDScript source file"

}
