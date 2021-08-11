package version.data

data class Method(
    val name: String,
    val type: String,
    val arguments: List<Argument>,
    val vararg: Boolean?
)
