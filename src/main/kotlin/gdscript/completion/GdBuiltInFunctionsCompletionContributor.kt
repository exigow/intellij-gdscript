package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.PlatformIcons.*
import gdscript.completion.utilities.ClassDeserializer.deserializeResource
import gdscript.completion.utilities.LookupCompletionProvider


class GdBuiltInFunctionsCompletionContributor : CompletionContributor() {

    init {
        val paths = listOf(
            "/docs/GDScript.xml",
            "/docs/Sprite.xml",
            "/docs/Vector2.xml",
            "/docs/String.xml"
        )
        for (path in paths) {
            val doc = deserializeResource(path)

            val classNameLookup = LookupElementBuilder.create(doc.name).withIcon(CLASS_ICON)
            val variableLookups = doc.usefulMembersNames().map { LookupElementBuilder.create(it).withIcon(VARIABLE_ICON) }
            val constantsLookups = doc.usefulConstantsNames().map { LookupElementBuilder.create(it).withIcon(VARIABLE_READ_ACCESS) }
            val methodLookups = doc.usefulMethodsNames().map { LookupElementBuilder.create(it).withIcon(METHOD_ICON) }

            extend(BASIC, psiElement(), LookupCompletionProvider(classNameLookup))
            extend(BASIC, psiElement(), LookupCompletionProvider(variableLookups))
            extend(BASIC, psiElement(), LookupCompletionProvider(constantsLookups))
            extend(BASIC, psiElement(), LookupCompletionProvider(methodLookups))
        }
    }

}
