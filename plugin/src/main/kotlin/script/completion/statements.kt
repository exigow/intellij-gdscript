package script.completion

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create

val VAR = createLookup("var")
val CONST = createLookup("const")
val FUNC = createLookup("func")
val FOR = createLookup("for")
val WHILE = createLookup("while")
val CLASS = createLookup("class")
val EXTENDS = createLookup("extends")
val CLASS_NAME = createLookup("class_name")
val ENUM = createLookup("enum")
val IF = createLookup("if")
val ELIF = createLookup("elif")
val ELSE = createLookup("else")
val RETURN = createLookup("return")
val SIGNAL = createLookup("signal")
val EXPORT = createLookup("export")
val STATIC = createLookup("static")
val MATCH = createLookup("match")

private fun createLookup(name: String): LookupElement = create(name)
    .bold()
    .withInsertHandler { ctx, _ ->
        if (!ctx.hasNextCharacter(' ')) {
            ctx.insert(" ")
            ctx.moveCaret(1)
        }
    }
