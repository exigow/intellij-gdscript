package gdscript

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader

object ScriptFileType : LanguageFileType(ScriptLanguage) {

    override fun getName() = "GDScript"

    override fun getDescription() = "GDScript Files"

    override fun getDefaultExtension() = "gd"

    override fun getIcon() = IconLoader.getIcon("/file_icon.png")

}
