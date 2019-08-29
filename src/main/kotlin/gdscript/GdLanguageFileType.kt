package gdscript

import com.intellij.openapi.fileTypes.LanguageFileType
import gdscript.icons.GdIcons

object GdLanguageFileType : LanguageFileType(GdLanguage) {

    override fun getName() = GdLanguage.displayName

    override fun getDescription() = "todo description"

    override fun getDefaultExtension() = "gd"

    override fun getIcon() = GdIcons.createPluginIcon()

}
