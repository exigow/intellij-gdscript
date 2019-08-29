package gdscript

import gdscript.icons.Icons

object LanguageFileType : com.intellij.openapi.fileTypes.LanguageFileType(GDScriptLanguage) {

    override fun getName() = GDScriptLanguage.displayName

    override fun getDescription() = "todo description"

    override fun getDefaultExtension() = "gd"

    override fun getIcon() = Icons.FILE_ICON

}
