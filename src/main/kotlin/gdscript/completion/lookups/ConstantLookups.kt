package gdscript.completion.lookups

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons

object ConstantLookups {

    fun createConstant(name: String, value: String): LookupElement =
        create(name)
            .withIcon(PlatformIcons.VARIABLE_ICON)
            .withTailText(" = $value")

    fun createSingleton(name: String): LookupElement =
        create(name)
            .withIcon(PlatformIcons.CLASS_ICON)
            .withItemTextItalic(true)

    fun createClass(name: String, extends: String): LookupElement =
        create(name)
            .withTypeText(extends)
            .withIcon(PlatformIcons.CLASS_ICON)
}