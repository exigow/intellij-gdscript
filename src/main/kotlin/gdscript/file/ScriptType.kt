package gdscript.file

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import gdscript.parser.ScriptLanguage

object ScriptType : LanguageFileType(ScriptLanguage) {

    override fun getIcon() = IconLoader.getIcon("/fileIcon.png")

    override fun getName() = "GDScript"

    override fun getDefaultExtension() = "gd"

    override fun getDescription() = "GDScript source file"

}
