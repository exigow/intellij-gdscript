package gdscript.file


import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import gdscript.parser.ResourceLanguage
import javax.swing.Icon

object ResourceType : LanguageFileType(ResourceLanguage) {

    override fun getIcon(): Icon = AllIcons.FileTypes.Config

    override fun getName() = "GDScript resource"

    override fun getDefaultExtension() = "cfg"

    override fun getDescription() = "GDScript resource file"

}