package gdscript.adaptors

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

open class LanguageFileTypeAdaptor(
    private val adaptedLanguage: Language,
    private val extension: String,
    private val adaptedIcon: Icon
) : LanguageFileType(adaptedLanguage) {

    override fun getName() = adaptedLanguage.id

    override fun getDescription() = "${adaptedLanguage.id} file"

    override fun getDefaultExtension() = extension

    override fun getIcon() = adaptedIcon

}