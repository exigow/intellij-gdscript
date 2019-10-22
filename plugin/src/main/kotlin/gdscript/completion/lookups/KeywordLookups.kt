package gdscript.completion.lookups

import com.intellij.codeInsight.completion.AddSpaceInsertHandler
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create

object KeywordLookups {

    fun createKeyword(name: String): LookupElement =
        create(name)
            .bold()

    fun createKeywordSpaced(name: String): LookupElement =
        create(name)
            .withInsertHandler(AddSpaceInsertHandler.INSTANCE_WITH_AUTO_POPUP)
            .bold()

}