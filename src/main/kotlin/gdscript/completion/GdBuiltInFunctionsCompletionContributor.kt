package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.PlatformIcons.*
import gdscript.completion.utilities.ClassDeserializer.deserializeResource
import gdscript.completion.utilities.PrioritizedLookupCompletionProvider
import gdscript.completion.utilities.models.Class
import gdscript.completion.utilities.models.Constant
import gdscript.completion.utilities.models.Member
import gdscript.completion.utilities.models.Method


class GdBuiltInFunctionsCompletionContributor : CompletionContributor() {

    init {
        val paths = listOf(
            "/docs/GDScript.xml",
            "/docs/Sprite.xml",
            "/docs/Vector2.xml",
            "/docs/String.xml"
        )
        for (path in paths) {
            val native: Class = deserializeResource(path)
            val name = native.toNameLookup()
            val variable = native.members?.map { it.toLookup() }.orEmpty()
            val constant = native.constants?.map { it.toLookup() }.orEmpty()
            val method = native.methods?.map { it.toLookup() }.orEmpty()

            extend(BASIC, psiElement(), PrioritizedLookupCompletionProvider(listOf(name)))
            extend(BASIC, psiElement(), PrioritizedLookupCompletionProvider(variable))
            extend(BASIC, psiElement(), PrioritizedLookupCompletionProvider(constant))
            extend(BASIC, psiElement(), PrioritizedLookupCompletionProvider(method))
        }
    }

    private fun Class.toNameLookup() =
        LookupElementBuilder.create(name)
            .withIcon(CLASS_ICON)
            .withTailText(" (native)")

    private fun Member.toLookup() =
        LookupElementBuilder.create(name)
            .withIcon(VARIABLE_ICON)
            .withTypeText(type)

    private fun Constant.toLookup() =
        LookupElementBuilder.create(name)
            .withIcon(FIELD_ICON)
            .withTailText(" = $value")

    private fun Method.toLookup() =
        LookupElementBuilder.create(name)
            .withIcon(METHOD_ICON)
            .withTailText("()") // todo: show argument types
            .withTypeText(returnType?.type)
}
