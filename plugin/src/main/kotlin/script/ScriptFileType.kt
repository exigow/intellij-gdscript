package script

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader

object ScriptFileType : LanguageFileType(ScriptLanguage) {

    override fun getIcon() =
        IconLoader.getIcon("/file_icon.png")

    override fun getName() =
        ScriptLanguage.displayName

    override fun getDefaultExtension() =
        "gd"

    override fun getDescription() =
        "${ScriptLanguage.displayName} file"

}
