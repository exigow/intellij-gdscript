package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import gdscript.completion.utilities.ClassDeserializer.deserializeResource
import gdscript.completion.utilities.PrioritizedLookupCompletionProvider
import gdscript.completion.utilities.models.Constant
import gdscript.icons.ColorIcon
import java.awt.Color

class GdColorCompletionContributor : CompletionContributor() {

    init {
        val doc = deserializeResource("/docs/Color.xml")
        for (colorConstant in doc.constants!!) {
            val lookup = createLookupFromConstant(colorConstant)
            extend(BASIC, psiElement(), PrioritizedLookupCompletionProvider(listOf(lookup)))
        }
    }

    private fun createLookupFromConstant(constant: Constant): LookupElementBuilder {
        val color = parseColor(constant.value)
        val icon = ColorIcon(color)
        val typeText = createTypeText(color)
        return LookupElementBuilder.create(constant.name)
            .withIcon(icon)
            .withTailText(typeText)
            .withTypeText("Color")
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

    private fun createTypeText(color: Color) = " = (${color.red}, ${color.green}, ${color.blue})"

}
