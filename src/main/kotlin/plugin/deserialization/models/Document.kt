package plugin.deserialization.models

data class Document(
    val name: String,
    val inherits: String?,
    val members: List<Member>?,
    val methods: List<Method>?,
    val constants: List<Constant>?
)