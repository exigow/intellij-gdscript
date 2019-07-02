package plugin

import com.intellij.openapi.fileTypes.LanguageFileType

object GDScriptFileType : LanguageFileType(GDScript) {

    const val FILE_EXTENSION = "gd"

    override fun getName() = "getName()"

    override fun getDescription() = "getDescription()"

    override fun getDefaultExtension() = FILE_EXTENSION

    override fun getIcon() = Icons.GODOT_ICON

}
