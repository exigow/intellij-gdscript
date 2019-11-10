package gdscript.fileType


import com.intellij.openapi.fileTypes.LanguageFileType
import gdscript.lang.IconCatalog
import gdscript.lang.ResourceLanguage

object ResourceType : LanguageFileType(ResourceLanguage) {

    override fun getIcon() = IconCatalog.RESOURCE_FILE

    override fun getName() = "GDScript resource"

    override fun getDefaultExtension() = "cfg"

    override fun getDescription() = "GDScript resource file"

}