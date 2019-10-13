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


val CLASSES = OBJECT_CLASSES.map { createClass(it) }
val CONSTANTS = LANGUAGE_CLASS.constants.map { createConstant(it) }
val CONSTRUCTOR_CALLS = (OBJECT_CLASSES + PRIMITIVE_CLASSES).map { createConstructorCall(it) }
val FUNCTION_CALLS = LANGUAGE_CLASS.methods.map { createFunctionCall(it) }
val PRIMITIVES = PRIMITIVE_CLASSES.map { createPrimitive(it) }
val VAR = listOf(create("var").withSpaceHandler().bold())
val CONST = listOf(create("const").withSpaceHandler().bold())
val FUNC = listOf(create("func").withSpaceHandler().bold())
val FOR = listOf(create("for").withSpaceHandler().bold())
val WHILE = listOf(create("while").withSpaceHandler().bold())
val CLASS = listOf(create("class").withSpaceHandler().bold())
val EXTENDS = listOf(create("extends").withSpaceHandler().bold())
val CLASS_NAME = listOf(create("class_name").withSpaceHandler().bold())
val ENUM = listOf(create("enum").withSpaceHandler().bold())
val IF = listOf(create("if").withSpaceHandler().bold())
val ELIF = listOf(create("elif").withSpaceHandler().bold())
val ELSE = listOf(create("else").withSpaceHandler().bold())
val RETURN = listOf(create("return").withSpaceHandler().bold())
val SIGNAL = listOf(create("signal").withSpaceHandler().bold())
val EXPORT = listOf(create("export").withSpaceHandler().bold())
val STATIC = listOf(create("static").withSpaceHandler().bold())
val SELF = listOf(create("self").bold())
val TRUE = listOf(create("true").bold())
val FALSE = listOf(create("false").bold())

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

private fun LookupElementBuilder.withSpaceHandler() =
    withInsertHandler { ctx, _ ->
        if (!ctx.hasNextCharacter(' ')) {
            ctx.insert(" ")
            ctx.moveCaret(1)
        }
    }

private fun LookupElementBuilder.withArgumentHandler(arguments: List<GodotApi.Class.Method.Argument>) =
    withInsertHandler { ctx, _ ->
        if (!ctx.hasNextCharacter('(')) {
            ctx.insert("()")
            if (arguments.isEmpty())
                ctx.moveCaret(2)
            else
                ctx.moveCaret(1)
        }
    }

private fun InsertionContext.hasNextCharacter(character: Char) =
    file.text[min(tailOffset, file.text.length - 1)] == character

private fun InsertionContext.insert(text: String) =
    document.insertString(selectionEndOffset, text)

private fun InsertionContext.moveCaret(steps: Int) =
    EditorModificationUtil.moveCaretRelatively(editor, steps)
