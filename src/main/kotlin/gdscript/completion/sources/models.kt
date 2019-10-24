package gdscript.completion.sources

data class Language(
    val constants: List<Constant>,
    val classes: List<Class>,
    val primitiveClasses: List<Class>,
    val functions: List<Method>,
    val singletons: List<Field>
)

data class Class(
    val name: String,
    val extends: String,
    val description: String,
    val fields: List<Field>,
    val methods: List<Method>,
    val constants: List<Constant>
)

data class Constant(
    val name: String,
    val value: String
)

data class Field(
    val name: String,
    val type: String,
    val setter: String,
    val getter: String,
    val default: String
)

data class Argument(
    val name: String,
    val type: String
)

data class Method(
    val name: String,
    val type: String,
    val arguments: List<Argument>
)
