package gdscript.lexer

object ScriptKeywords {

    val VALUES = listOf(
        "self",
        "true",
        "false",
        "null"
    )
    val PRIMITIVES = listOf(
        "bool",
        "int",
        "float",
        "void"
    )
    val KEYWORDS = listOf(
        "remote",
        "puppet",
        "master",
        "sync",
        "remotesync",
        "mastersync",
        "puppetsync",
        "match",
        "export",
        "onready",
        "var",
        "setget",
        "const",
        "static",
        "func",
        "for",
        "while",
        "class",
        "extends",
        "class_name",
        "enum",
        "if",
        "elif",
        "else",
        "return",
        "signal",
        "not",
        "pass",
        "break",
        "continue",
        "tool",
        "in",
        "and",
        "or",
        "is",
        "as"
    )

}