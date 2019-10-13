package script.completion

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create

val VAR = createStatement("var")
val CONST = createStatement("const")
val FUNC = createStatement("func")
val FOR = createStatement("for")
val WHILE = createStatement("while")
val CLASS = createStatement("class")
val EXTENDS = createStatement("extends")
val CLASS_NAME = createStatement("class_name")
val ENUM = createStatement("enum")
val IF = createStatement("if")
val ELIF = createStatement("elif")
val ELSE = createStatement("else")
val RETURN = createStatement("return")
val SIGNAL = createStatement("signal")
val EXPORT = createStatement("export")
val STATIC = createStatement("static")

private fun createStatement(name: String): LookupElement = create(name)
    .bold()
    .withInsertHandler { ctx, _ ->
        if (!ctx.hasNextCharacter(' ')) {
            ctx.insert(" ")
            ctx.moveCaret(1)
        }
    }
