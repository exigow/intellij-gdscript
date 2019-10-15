package gdscript.files

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader

abstract class BaseFileType(private val extension: String, language: Language) : LanguageFileType(language) {

    override fun getIcon() = IconLoader.getIcon("/file_icon.png")

    override fun getName() = language.displayName

    override fun getDefaultExtension() = extension

    override fun getDescription() = "${language.displayName} file"

}
