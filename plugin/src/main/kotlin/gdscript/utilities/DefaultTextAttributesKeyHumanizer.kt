package gdscript.utilities

import com.intellij.openapi.editor.colors.TextAttributesKey

object DefaultTextAttributesKeyHumanizer {

    fun humanize(attribute: TextAttributesKey) = attribute.externalName
        .trim()
        .split("_")
        .map { it.toLowerCase() }
        .filter { it != "default" }
        .joinToString(" ")
        .capitalize()
}