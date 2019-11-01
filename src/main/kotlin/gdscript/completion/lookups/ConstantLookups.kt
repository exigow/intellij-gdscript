package gdscript.completion.lookups

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import gdscript.icons.IconCatalog

object ConstantLookups {

    fun createConstant(name: String, value: String): LookupElement =
        create(name)
            .withIcon(IconCatalog.STATIC_VARIABLE)
            .withTailText(" = $value")

    fun createSingleton(name: String): LookupElement =
        create(name)
            .withIcon(IconCatalog.STATIC_CLASS)

    fun createClass(name: String, extends: String): LookupElement =
        create(name)
            .withTypeText(extends)
            .withIcon(IconCatalog.CLASS)

}