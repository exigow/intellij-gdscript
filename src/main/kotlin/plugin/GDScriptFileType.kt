package plugin

import com.intellij.openapi.fileTypes.LanguageFileType
import plugin.icons.GDScriptIconFactory

object GDScriptFileType : LanguageFileType(GDScript) {

    override fun getName() = GDScript.displayName

    override fun getDescription() = "todo description"

    override fun getDefaultExtension() = "gd"

    override fun getIcon() = GDScriptIconFactory.createLogo()

}
