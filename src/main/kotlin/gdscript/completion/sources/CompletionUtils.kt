package gdscript.completion.sources

object CompletionUtils {

    val CLASSES =
        CompletionDeserializer.deserialize().classes
    val SINGLETONS =
        CLASSES.filter { it.name in collectSingletonNames() }
    val LANGUAGE_CONSTANTS =
        CLASSES.filter { isGlobal(it) }.flatMap { it.constants.orEmpty() }
    val FUNCTIONS =
        CLASSES.filter { isGlobal(it) }.flatMap { it.methods.orEmpty() }
    val PRIMITIVES =
        CLASSES.filter { isPrimitive(it) }
    val CLASS_CONSTRUCTORS =
        toConstructors(CLASSES)
    val PRIMITIVE_CONSTRUCTORS =
        toConstructors(PRIMITIVES)
    val VARIABLE_KEYWORDS =
        listOf("self", "true", "false", "null")
    val STATEMENT_KEYWORDS =
        listOf("remote", "sync", "var", "const", "func", "for", "while", "class", "extends", "class_name", "enum", "if", "elif", "else", "return", "signal", "export", "static", "puppet", "master", "match", "tool", "pass", "break", "continue")

    fun findClass(name: String?) =
        CLASSES.find { it.name == name }

    private fun collectSingletonNames() =
        CLASSES.filter { isGlobal(it) }.flatMap { it.fields.orEmpty() }.map { it.name }

    private fun toConstructors(classes: List<Class>) =
        classes.flatMap { c -> c.methods?.filter { it -> c.name == it.name }.orEmpty() }

    private fun isGlobal(clazz: Class) =
        clazz.name.startsWith("@")

    private fun isPrimitive(clazz: Class) =
        clazz.name in listOf("bool", "float", "void", "int")

}