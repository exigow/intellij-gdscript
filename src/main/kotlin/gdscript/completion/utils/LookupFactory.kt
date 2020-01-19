package gdscript.completion.utils

import com.intellij.codeInsight.completion.AddSpaceInsertHandler.INSTANCE_WITH_AUTO_POPUP
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler.NO_PARAMETERS
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler.WITH_PARAMETERS
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import gdscript.completion.sources.Argument
import gdscript.completion.sources.Class
import gdscript.completion.sources.Constant
import gdscript.completion.sources.Method
import gdscript.lang.IconCatalog.CLASS
import gdscript.lang.IconCatalog.FUNCTION
import gdscript.lang.IconCatalog.STATIC_CLASS
import gdscript.lang.IconCatalog.STATIC_METHOD
import gdscript.lang.IconCatalog.STATIC_VARIABLE

object LookupFactory {

    fun createFunction(function: Method): LookupElement =
        create(function.name)
            .withIcon(FUNCTION)
            .withTypeText(function.type)
            .withArgumentsTail(function.arguments)
            .withParenthesesInsertHandler(function.arguments)
            .bold()

    fun createConstructor(constructor: Method): LookupElement =
        create(constructor.name)
            .withIcon(CLASS)
            .withArgumentsTail(constructor.arguments)
            .withParenthesesInsertHandler(constructor.arguments)

    fun createPrimitiveConstructor(constructor: Method): LookupElement =
        create(constructor.name)
            .withArgumentsTail(constructor.arguments)
            .withParenthesesInsertHandler(constructor.arguments)
            .bold()

    fun createConstant(constant: Constant): LookupElement =
        create(constant.name)
            .withIcon(STATIC_VARIABLE)
            .withTailText(" = ${cleanConstantValue(constant.value)}")

    fun createClass(it: Class): LookupElement =
        create(it.name)
            .withTypeText(it.extends)
            .withIcon(CLASS)

    fun createClassname(name: String): LookupElement =
        create(name)
            .bold()

    fun createSingleton(clazz: Class): LookupElement =
        create(clazz.name)
            .withIcon(STATIC_CLASS)

    fun createKeyword(keyword: String): LookupElement =
        create(keyword)
            .bold()

    fun createKeywordWithSpace(keyword: String): LookupElement =
        create(keyword)
            .withInsertHandler(INSTANCE_WITH_AUTO_POPUP)
            .bold()

    fun createStaticMethod(method: Method): LookupElement =
        create(method.name)
            .withIcon(STATIC_METHOD)
            .withArgumentsTail(method.arguments)
            .withParenthesesInsertHandler(method.arguments)
            .withTypeText(method.type)
            .bold()

    private fun LookupElementBuilder.withArgumentsTail(args: List<Argument>): LookupElementBuilder {
        val formatted = args.joinToString(", ", "(", ")") {
            "${it.name}: ${it.type}"
        }
        return withTailText(formatted)
    }

    private fun LookupElementBuilder.withParenthesesInsertHandler(args: List<Argument>): LookupElementBuilder =
        if (args.isEmpty())
            withInsertHandler(NO_PARAMETERS)
        else
            withInsertHandler(WITH_PARAMETERS)

    private fun cleanConstantValue(code: String) = code
        .replace(" ", "")
        .replace(",", ", ")

}
