package plugin

import com.intellij.openapi.fileTypes.LanguageFileType
import plugin.icons.GDScriptIconFactory

object GDScriptFileType : LanguageFileType(GDScript) {

    const val FILE_EXTENSION = "gd"

    override fun getName() = GDScript.displayName

    override fun getDescription() = "todo description"

    override fun getDefaultExtension() = FILE_EXTENSION

    override fun getIcon() = GDScriptIconFactory.createLogo()

}
