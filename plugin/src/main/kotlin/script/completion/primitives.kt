package script.completion

import GodotApi
import GodotApi.PRIMITIVE_CLASSES
import com.intellij.codeInsight.lookup.LookupElementBuilder.create

val PRIMITIVE_TYPES = PRIMITIVE_CLASSES
    .map { it.toPrimitiveLookup() }

private fun GodotApi.Class.toPrimitiveLookup() = create(name)
    .withCaseSensitivity(false)
    .bold()
