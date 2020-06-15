package classes.model

data class Field(
    val name: String,
    val type: String,
    val setter: String,
    val getter: String,
    val default: String
)