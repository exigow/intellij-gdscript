package gdscript.adaptors

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

open class LanguageFileTypeAdaptor(
    language: Language,
    private val name: String,
    private val description: String,
    private val extension: String,
    private val icon: Icon
) : LanguageFileType(language) {

    override fun getName() =
        name

    override fun getDescription() =
        description

    override fun getDefaultExtension() =
        extension

    override fun getIcon() =
        icon

}