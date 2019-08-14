package plugin.deserialization.models

data class Member(
    val name: String,
    val type: String,
    val setter: String,
    val getter: String
)