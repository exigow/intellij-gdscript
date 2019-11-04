package gdscript.completion.sources

object CompletionUtils {

    private val COMPLETION_DATA = CompletionDeserializer.deserialize()

    fun singletons() =
        COMPLETION_DATA.singletons

    fun constants() =
        COMPLETION_DATA.constants

    fun functions() =
        COMPLETION_DATA.functions

    fun classes() =
        COMPLETION_DATA.classes

    fun primitives() =
        COMPLETION_DATA.primitiveClasses

    fun findClass(name: String?): Class? {
        val allClasses = COMPLETION_DATA.classes + COMPLETION_DATA.singletons
        return allClasses
            .find { it.name == name }
    }

    fun keywordVariables() = listOf(
        "self",
        "true",
        "false",
        "null"
    )

    fun keywordsStatements() = listOf(
        "remote",
        "sync",
        "var",
        "const",
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
        "export",
        "static",
        "puppet",
        "master",
        "match",
        "tool",
        "pass",
        "break",
        "continue"
    )

    fun classConstructors(): List<Method> =
        COMPLETION_DATA.classes
            .flatMap { it.methods.filter { method -> method.name == it.name } }

    fun primitiveConstructors(): List<Method> =
        COMPLETION_DATA.primitiveClasses
            .flatMap { it.methods.filter { method -> method.name == it.name } }

    fun isClass(name: String?) =
        COMPLETION_DATA.classes
            .map { it.name }
            .contains(name)

}