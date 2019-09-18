package gdscript.utilities

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor

object HumanizedAttributeDescriptorsFactory {

    fun create(attributes: Set<TextAttributesKey>): Array<AttributesDescriptor> =
        attributes.map { AttributesDescriptor(humanize(it), it) }
            .toTypedArray()

    private fun humanize(attribute: TextAttributesKey) = attribute.externalName
        .trim()
        .split("_")
        .map { it.toLowerCase() }
        .filter { it != "default" }
        .joinToString(" ")
        .capitalize()
}