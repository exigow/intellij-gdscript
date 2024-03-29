package version.data

data class Class(
    val name: String,
    val briefDescription: String,
    val extends: String?,
    val fields: List<Field>,
    val methods: List<Method>,
    val constants: List<Constant>,
    val signals: List<Signal>
)