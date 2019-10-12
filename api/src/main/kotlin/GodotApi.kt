import com.google.gson.Gson

object GodotApi {

    val OBJECT_CLASSES: List<Class>
    val PRIMITIVE_CLASSES: List<Class>
    val LANGUAGE_CLASS: Class

    init {
        val (primitive, nonPrimitive) = deserialize().partition { it.name in listOf("float", "int", "bool") }
        PRIMITIVE_CLASSES = primitive
        OBJECT_CLASSES = nonPrimitive
        LANGUAGE_CLASS = OBJECT_CLASSES.find { it.name == "@GDScript" }!!
    }

    private fun deserialize(): Array<Class> {
        val inputStream = this::class.java.classLoader.getResourceAsStream("api.json")!!.reader()
        return Gson().fromJson<Array<Class>>(inputStream, Array<Class>::class.java)
    }

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
