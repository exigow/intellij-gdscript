package gdscript

import com.intellij.openapi.fileTypes.LanguageFileType
import common.Icons

object ScriptFileType : LanguageFileType(ScriptLanguage) {

    override fun getIcon() = Icons.GDSCRIPT_FILE

    override fun getName() = "GDScript"

    override fun getDefaultExtension() = "gd"

    override fun getDescription() = name

}
