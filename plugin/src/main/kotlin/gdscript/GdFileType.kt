package gdscript

import com.intellij.openapi.fileTypes.LanguageFileType

object GdFileType : LanguageFileType(GdLanguage) {

    override fun getName() = "GDScript"

    override fun getDescription() = "GDScript Files"

    override fun getDefaultExtension() = "gd"

    override fun getIcon() = GdIcons.FILE_ICON

}
