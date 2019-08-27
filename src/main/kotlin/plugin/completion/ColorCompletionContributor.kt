package plugin.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import plugin.completion.deserialization.DocumentationDeserializer.deserializeResourceResource
import plugin.completion.deserialization.models.Constant
import plugin.completion.utilities.LookupCompletionProvider
import plugin.icons.IconFactory
import java.awt.Color

class ColorCompletionContributor : CompletionContributor() {

    init {
        val doc = deserializeResourceResource("/docs/Color.xml")
        for (colorConstant in doc.constants!!) {
            val lookup = createLookupFromConstant(colorConstant)
            extend(BASIC, psiElement(), LookupCompletionProvider(lookup))
        }
    }

    private fun createLookupFromConstant(constant: Constant): LookupElementBuilder {
        val color = parseColor(constant.value)
        val icon = createIcon(color)
        val typeText = createTypeText(color)
        return LookupElementBuilder.create(constant.name)
            .withIcon(icon)
            .withTypeText(typeText)
    }

    private fun parseColor(code: String): Color {
        val channels = readColorChannels(code)
        return Color(channels[0], channels[1], channels[2], channels[3])
    }

    private fun readColorChannels(constructorInvocationCode: String) = constructorInvocationCode
        .replace("Color", "")
        .removeSurrounding("(", ")")
        .split(",")
        .map { it.trim() }
        .map { it.toFloat() }

    private fun createIcon(color: Color) = IconFactory.createColorIcon(color)

    private fun createTypeText(color: Color) = "Color(${color.red}, ${color.green}, ${color.blue})"

}
