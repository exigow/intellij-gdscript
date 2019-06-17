package plugin

import com.intellij.openapi.fileTypes.LanguageFileType

class GDScriptFileType : LanguageFileType(GDScript) {

    override fun getName() = "getName()"

    override fun getDescription() = "getDescription()"

    override fun getDefaultExtension() = FILE_EXTENSION

    override fun getIcon() = Icons.GODOT_ICON

    companion object {

        val FILE_EXTENSION = "gd"
        val INSTANCE = GDScriptFileType()

    }

}
