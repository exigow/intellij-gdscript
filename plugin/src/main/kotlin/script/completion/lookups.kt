package script.completion

import GodotApi
import GodotApi.LANGUAGE_CLASS
import GodotApi.OBJECT_CLASSES
import GodotApi.PRIMITIVE_CLASSES
import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.openapi.editor.EditorModificationUtil
import com.intellij.util.PlatformIcons.*
import kotlin.math.min


val CLASS_LOOKUPS = OBJECT_CLASSES.map { createClass(it) }
val CONSTANT_LOOKUPS = LANGUAGE_CLASS.constants.map { createConstant(it) }
val CONSTRUCTOR_CALL_LOOKUPS = (OBJECT_CLASSES + PRIMITIVE_CLASSES).map { createConstructorCall(it) }
val SELF_TRUE_FALSE_LOOKUPS = listOf("self", "true", "false").map { create(it).bold() }
val FUNCTION_CALL_LOOKUPS = LANGUAGE_CLASS.methods.map { createFunctionCall(it) }
val PRIMITIVE_LOOKUPS = PRIMITIVE_CLASSES.map { createPrimitive(it) }
val VAR_LOOKUP = create("var").bold()!!
val FUNC_LOOKUP = create("func").bold()!!

private fun createClass(it: GodotApi.Class) = create(it.name)
    .notCaseSensitive()
    .withIcon(CLASS_ICON)

private fun createConstant(it: GodotApi.Class.Constant) = create(it.name)
    .withIcon(VARIABLE_ICON)
    .withTailText(" = ${it.value}")
    .italics()
    .bold()

private fun createConstructorCall(it: GodotApi.Class) = create(it.name)
    .withIcon(CLASS_ICON)
    .withTypeText(it.name)
    .withArgumentsTail(emptyList())
    .withArgumentHandler(emptyList())

private fun createFunctionCall(it: GodotApi.Class.Method) = create(it.name)
    .withIcon(FUNCTION_ICON)
    .withTypeText(it.type)
    .withArgumentsTail(it.arguments)
    .withArgumentHandler(it.arguments)
    .italics()

private fun createPrimitive(it: GodotApi.Class) = create(it.name)
    .notCaseSensitive()
    .withIcon(CLASS_ICON)
    .bold()

private fun LookupElementBuilder.notCaseSensitive() = withCaseSensitivity(false)

private fun LookupElementBuilder.italics() = withItemTextItalic(true)

private fun LookupElementBuilder.withArgumentsTail(arguments: List<GodotApi.Class.Method.Argument>) =
    withTailText(arguments.joinToString(", ", "(", ")") { "${it.name}: ${it.type}" })

private fun LookupElementBuilder.withArgumentHandler(arguments: List<GodotApi.Class.Method.Argument>) =
    withInsertHandler { ctx, _ ->
        if (ctx.hasNoOpenBraceAfterCaret()) {
            ctx.insertParentheses()
            if (arguments.isEmpty())
                ctx.moveCaret(2)
            else
                ctx.moveCaret(1)
        }
    }

private fun InsertionContext.hasNoOpenBraceAfterCaret() =
    file.text[min(tailOffset, file.text.length - 1)] != '('

private fun InsertionContext.insertParentheses() =
    document.insertString(selectionEndOffset, "()")

private fun InsertionContext.moveCaret(steps: Int) =
    EditorModificationUtil.moveCaretRelatively(editor, steps)
