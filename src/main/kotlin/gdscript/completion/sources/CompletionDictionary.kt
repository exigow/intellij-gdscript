package gdscript.completion.sources

object CompletionDictionary {

    val CLASSES =
        CompletionDeserializer.deserialize()
    val SINGLETONS =
        CLASSES.filter { it.name in collectSingletonNames() }
    val LANGUAGE_CONSTANTS =
        CLASSES.filter { isGlobal(it) }.flatMap { it.constants.orEmpty() }
    val LANGUAGE_CONSTANT_NAMES =
        LANGUAGE_CONSTANTS.map { it.name }.toSet()
    val FUNCTIONS =
        CLASSES.filter { isGlobal(it) }.flatMap { it.methods.orEmpty() }
    val FUNCTION_NAMES =
        FUNCTIONS.map { it.name }.toSet()
    val PRIMITIVES =
        CLASSES.filter { isPrimitive(it) }.toTypedArray()
    val NON_PRIMITIVE_CLASS_NAMES =
        (CLASSES.toList() - PRIMITIVES).map { it.name }.toSet()
    val CLASS_CONSTRUCTORS =
        toConstructors(CLASSES)
    val PRIMITIVE_CONSTRUCTORS =
        toConstructors(PRIMITIVES)
    val VARIABLE_KEYWORDS =
        setOf("self", "true", "false", "null")
    val KEYWORDS =
        setOf(
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
            "as",
            "bool",
            "int",
            "float",
            "void"
        )


    fun findClass(name: String?) =
        CLASSES.find { it.name == name }

    private fun collectSingletonNames() =
        CLASSES.filter { isGlobal(it) }.flatMap { it.fields.orEmpty() }.map { it.name }

    private fun toConstructors(classes: Array<Class>) =
        classes.flatMap { c -> c.methods?.filter { it -> c.name == it.name }.orEmpty() }

    private fun isGlobal(clazz: Class) =
        clazz.name.startsWith("@")

    private fun isPrimitive(clazz: Class) =
        clazz.name in listOf("bool", "float", "void", "int")

}