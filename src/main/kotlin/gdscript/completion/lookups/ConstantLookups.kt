package gdscript.completion.lookups

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons.*

object ConstantLookups {

    fun createConstant(name: String, value: String): LookupElement =
        create(name)
            .withIcon(VARIABLE_ICON)
            .withTailText(" = $value")

    fun createSingleton(name: String): LookupElement =
        create(name)
            .withIcon(INTERFACE_ICON)

    fun createClass(name: String, extends: String): LookupElement =
        create(name)
            .withTypeText(extends)
            .withIcon(CLASS_ICON)

}