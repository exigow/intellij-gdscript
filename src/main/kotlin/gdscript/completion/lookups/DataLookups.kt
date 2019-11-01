package gdscript.completion.lookups

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import gdscript.icons.IconCatalog

object DataLookups {

    fun createClass(name: String, path: String, completedText: String): LookupElement =
        create(completedText)
            .withPresentableText(name)
            .withIcon(IconCatalog.CLASS)
            .withTypeText(path)
            .bold()

    fun createFile(path: String, completedText: String): LookupElement =
        create(completedText)
            .withPresentableText(path)

}