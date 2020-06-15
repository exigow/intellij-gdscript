package classes

object GDScriptGrammar {

    val VARIABLE_KEYWORDS = setOf(
        "self",
        "true",
        "false",
        "null"
    )
    val PRIMITIVE_KEYWORDS = setOf(
        "bool",
        "int",
        "float",
        "void"
    )
    val KEYWORDS = setOf(
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