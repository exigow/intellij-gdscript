package plugin

import com.intellij.openapi.fileTypes.LanguageFileType

class GDScriptFileType : LanguageFileType(SampleLanguage) {

    override fun getName() = "name ???"

    override fun getDescription() = "description ???"

    override fun getDefaultExtension() = FILE_EXTENSION

    override fun getIcon() = Icons.SAMPLE_ICON

    companion object {

        @JvmField val FILE_EXTENSION = "gd"
        @JvmField val INSTANCE = GDScriptFileType()

    }

}
