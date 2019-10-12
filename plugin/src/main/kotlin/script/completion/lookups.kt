package script.completion

import GodotApi
import GodotApi.LANGUAGE_CLASS
import GodotApi.OBJECT_CLASSES
import GodotApi.PRIMITIVE_CLASSES
import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.openapi.editor.EditorModificationUtil
import com.intellij.util.PlatformIcons
import com.intellij.util.PlatformIcons.CLASS_ICON
import com.intellij.util.PlatformIcons.FUNCTION_ICON
import kotlin.math.min


val CLASS_LOOKUPS = OBJECT_CLASSES.map { createClass(it) }
val CONSTANT_LOOKUPS = LANGUAGE_CLASS.constants.map { createConstant(it) }
val CONSTRUCTOR_CALL_LOOKUPS = (OBJECT_CLASSES + PRIMITIVE_CLASSES).map { createConstructorCall(it) }
val SELF_TRUE_FALSE_LOOKUPS = listOf("self", "true", "false").map { create(it).bold() }
val FUNCTION_CALL_LOOKUPS = LANGUAGE_CLASS.methods.map { createFunctionCall(it) }
val PRIMITIVE_LOOKUPS = PRIMITIVE_CLASSES.map { createPrimitive(it) }

private fun createClass(it: GodotApi.Class) = create(it.name)
    .withIcon(CLASS_ICON)
    .withCaseSensitivity(false)

private fun createConstant(it: GodotApi.Class.Constant) = create(it.name)
    .withItemTextItalic(true)
    .withTailText(" = ${it.value}")
    .withIcon(PlatformIcons.VARIABLE_ICON).bold()

private fun createConstructorCall(it: GodotApi.Class) = create(it.name)
    .withIcon(CLASS_ICON)
    .withTailText("()")
    .withTypeText(it.name)
    .withArgumentsInsertHandler()

private fun createFunctionCall(it: GodotApi.Class.Method) = create(it.name)
    .withIcon(FUNCTION_ICON)
    .withItemTextItalic(true)
    .withArgumentsTail(it.arguments)
    .withTypeText(it.type)
    .withArgumentsInsertHandler(it.arguments)

private fun createPrimitive(it: GodotApi.Class) = create(it.name).bold()
    .withCaseSensitivity(false)

private fun LookupElementBuilder.withArgumentsTail(arguments: List<GodotApi.Class.Method.Argument>) =
    withTailText(arguments.joinToString(", ", "(", ")") { "${it.name}: ${it.type}" })

private fun LookupElementBuilder.withArgumentsInsertHandler(arguments: List<GodotApi.Class.Method.Argument> = emptyList()) =
    withInsertHandler { ctx, _ ->
        if (ctx.hasNoOpenBraceAfterCaret()) {
            ctx.insert("()")
            if (arguments.isEmpty())
                ctx.moveCaret(2)
            else
                ctx.moveCaret(1)
        }
    }

private fun InsertionContext.hasNoOpenBraceAfterCaret() =
    file.text[min(tailOffset, file.text.length - 1)] != '('

private fun InsertionContext.insert(text: String) =
    document.insertString(selectionEndOffset, text)

private fun InsertionContext.moveCaret(steps: Int) =
    EditorModificationUtil.moveCaretRelatively(editor, steps)
