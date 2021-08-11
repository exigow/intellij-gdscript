package version.data

data class Version(
    val version: String,
    val classes: List<Class>,
    val primitives: List<Class>,
    val singletons: List<Class>,
    val globals: List<Class>
)