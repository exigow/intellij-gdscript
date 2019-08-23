package plugin

import com.intellij.openapi.fileTypes.LanguageFileType
import plugin.icons.IconFactory

object GDScriptFileType : LanguageFileType(GDScript) {

    override fun getName() = GDScript.displayName

    override fun getDescription() = "todo description"

    override fun getDefaultExtension() = "gd"

    override fun getIcon() = IconFactory.createPluginIcon()

}
