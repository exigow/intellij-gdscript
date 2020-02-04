package scene


import com.intellij.openapi.fileTypes.LanguageFileType
import common.Icons

object ResourceType : LanguageFileType(ResourceLanguage) {

    override fun getIcon() = Icons.SCENE_FILE

    override fun getName() = "GDScript resource"

    override fun getDefaultExtension() = "tres"

    override fun getDescription() = name

}