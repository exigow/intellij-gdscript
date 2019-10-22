package gdscript.completion.lookups

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import gdscript.file.ScriptType

object DataLookups {

    fun createClass(name: String, path: String, completedText: String): LookupElement =
        create(completedText)
            .withPresentableText(name)
            .withIcon(ScriptType.icon)
            .withTypeText(path)
            .bold()

    fun createFile(path: String, completedText: String): LookupElement =
        create(completedText)
            .withPresentableText(path)

}