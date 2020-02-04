package scene


import com.intellij.openapi.fileTypes.LanguageFileType
import common.Icons

object SceneType : LanguageFileType(SceneLanguage) {

    override fun getIcon() = Icons.SCENE_FILE

    override fun getName() = "Scene"

    override fun getDefaultExtension() = "tres"

    override fun getDescription() = name

}