package gdscript.completion.sources

object CompletionUtils {

    private val COMPLETION_DATA = CompletionDeserializer.deserialize()
    val SINGLETONS = COMPLETION_DATA.singletons
    val LANGUAGE_CONSTANTS = COMPLETION_DATA.constants
    val FUNCTIONS = COMPLETION_DATA.functions
    val CLASSES = COMPLETION_DATA.classes
    val PRIMITIVES = COMPLETION_DATA.primitiveClasses
    val CLASS_CONSTRUCTORS = toConstructors(COMPLETION_DATA.classes)
    val PRIMITIVE_CONSTRUCTORS = toConstructors(COMPLETION_DATA.primitiveClasses)
    val VARIABLE_KEYWORDS = listOf("self", "true", "false", "null")
    val STATEMENT_KEYWORDS = listOf("remote", "sync", "var", "const", "func", "for", "while", "class", "extends", "class_name", "enum", "if", "elif", "else", "return", "signal", "export", "static", "puppet", "master", "match", "tool", "pass", "break", "continue")

    private fun toConstructors(classes: List<Class>) =
        classes.flatMap { it.methods?.filter { method -> method.name == it.name }.orEmpty() }

    fun findClass(name: String?): Class? {
        val allClasses = COMPLETION_DATA.classes + COMPLETION_DATA.singletons
        return allClasses
            .find { it.name == name }
    }

    fun isPrimitive(name: String?) =
        COMPLETION_DATA.primitiveClasses
            .map { it.name }
            .contains(name)

}