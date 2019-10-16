package gdscript.file

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import gdscript.parser.ResourceLanguage

object ResourceType : LanguageFileType(ResourceLanguage) {

    override fun getIcon() = IconLoader.getIcon("/file_icon.png")

    override fun getName() = "GDScript resource"

    override fun getDefaultExtension() = "cfg"

    override fun getDescription() = "GDScript resource file"

}