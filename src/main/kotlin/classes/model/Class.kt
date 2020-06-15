package classes.model

data class Class(
    val name: String,
    val extends: String?,
    val fields: List<Field>?,
    val methods: List<Method>?,
    val constants: List<Constant>?
)