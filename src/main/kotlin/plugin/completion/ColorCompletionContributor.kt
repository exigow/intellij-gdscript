package plugin.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import plugin.completion.deserialization.DocumentationDeserializer.deserializeResourceResource
import plugin.completion.deserialization.utilities.ColorParser
import plugin.completion.utilities.LookupCompletionProvider
import plugin.icons.IconFactory
import java.awt.Color

class ColorCompletionContributor : CompletionContributor() {

    init {
        val doc = deserializeResourceResource("/docs/Color.xml")
        for (constant in doc.constants!!) {
            val name = constant.name
            val color = ColorParser.parse(constant.value)
            val colorIcon = createIcon(color)
            val typeText = createTypeText(color)
            val lookup = LookupElementBuilder.create(name).withIcon(colorIcon).withTypeText(typeText)
            extend(BASIC, psiElement(), LookupCompletionProvider(lookup))
        }
    }

    private fun createIcon(color: Color) = IconFactory.createColorIcon(color)

    private fun createTypeText(color: Color) = "Color(${color.red}, ${color.green}, ${color.blue})"

}
