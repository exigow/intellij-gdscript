import com.google.gson.Gson

object GodotApi {

    val PRIMITIVE_CLASSES: List<Class>
    val OBJECT_CLASSES: List<Class>
    val GLOBAL_SCOPE_CLASSES: List<Class>

    init {
        val all = deserialize()
        val (primitive, nonPrimitives) = all.partition { isPrimitive(it) }
        PRIMITIVE_CLASSES = primitive
        val (objects, globalScopes) = nonPrimitives.partition { !it.name.startsWith("@") }
        OBJECT_CLASSES = objects
        GLOBAL_SCOPE_CLASSES = globalScopes
    }

    private fun deserialize(): Array<Class> {
        val inputStream = this::class.java.classLoader.getResourceAsStream("api.json")!!.reader()
        return Gson().fromJson<Array<Class>>(inputStream, Array<Class>::class.java)
    }

    private fun isPrimitive(clazz: Class) = clazz.name in listOf("float", "int", "bool")

    data class Class(
        val name: String,
        val extends: String,
        val description: String,
        val fields: List<Field>,
        val methods: List<Method>,
        val constants: List<Constant>
    ) {
        data class Field(
            val name: String,
            val type: String,
            val setter: String,
            val getter: String,
            val default: String
        )
        data class Method(
            val name: String,
            val type: String,
            val arguments: List<Argument>
        ) {
            data class Argument(
                val name: String,
                val type: String
            )
        }
        data class Constant(
            val name: String,
            val value: String
        )
    }

}
