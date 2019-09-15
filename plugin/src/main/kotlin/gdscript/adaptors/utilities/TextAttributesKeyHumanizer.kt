package gdscript.adaptors.utilities

import com.intellij.openapi.editor.colors.TextAttributesKey

object TextAttributesKeyHumanizer {

    fun humanize(attribute: TextAttributesKey) =
        attribute.externalName
            .trim()
            .split("_")
            .map { it.toLowerCase() }
            .filter { it != "default" }
            .joinToString(" ")
            .capitalize()
}