package gdscript.completion.utils

import api.model.Argument
import api.model.Class
import api.model.Constant
import api.model.Method
import com.intellij.codeInsight.completion.AddSpaceInsertHandler.INSTANCE_WITH_AUTO_POPUP
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler.NO_PARAMETERS
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler.WITH_PARAMETERS
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import common.Icons.CLASS
import common.Icons.FUNCTION
import common.Icons.STATIC_CLASS
import common.Icons.STATIC_METHOD
import common.Icons.STATIC_VARIABLE

object LookupFactory {

    fun createFunction(function: Method): LookupElement =
        create(function.name)
            .withIcon(FUNCTION)
            .withTypeText(function.type)
            .withArgumentsTail(function.arguments, function.vararg)
            .withParenthesesInsertHandler(function.arguments, function.vararg)
            .bold()

    fun createConstructor(constructor: Method): LookupElement =
        create(constructor.name)
            .withIcon(CLASS)
            .withArgumentsTail(constructor.arguments, constructor.vararg)
            .withParenthesesInsertHandler(constructor.arguments, constructor.vararg)

    fun createPrimitiveConstructor(constructor: Method): LookupElement =
        create(constructor.name)
            .withArgumentsTail(constructor.arguments, constructor.vararg)
            .withParenthesesInsertHandler(constructor.arguments, constructor.vararg)
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
            .withArgumentsTail(method.arguments, method.vararg)
            .withParenthesesInsertHandler(method.arguments, method.vararg)
            .withTypeText(method.type)
            .bold()

    private fun LookupElementBuilder.withArgumentsTail(args: List<Argument>?, vararg: Boolean?): LookupElementBuilder {
        if (vararg == true)
            return withTailText("(...)")
        if (args == null || args.isEmpty())
            return withTailText("()")
        return withTailText(args.joinToString(", ", "(", ")") { "${it.name}: ${it.type}" })
    }

    private fun LookupElementBuilder.withParenthesesInsertHandler(args: List<Argument>?, vararg: Boolean?): LookupElementBuilder {
        if (vararg == true)
            return withInsertHandler(WITH_PARAMETERS)
        if (args == null || args.isEmpty())
            return withInsertHandler(NO_PARAMETERS)
        return withInsertHandler(WITH_PARAMETERS)
    }

    private fun cleanConstantValue(code: String) = code
        .replace(" ", "")
        .replace(",", ", ")

}
