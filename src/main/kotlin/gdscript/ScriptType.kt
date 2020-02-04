package gdscript

import com.intellij.openapi.fileTypes.LanguageFileType
import common.Icons

object ScriptType : LanguageFileType(ScriptLanguage) {

    override fun getIcon() = Icons.GDSCRIPT_FILE

    override fun getName() = "GDScript"

    override fun getDefaultExtension() = "gd"

    override fun getDescription() = name

}
