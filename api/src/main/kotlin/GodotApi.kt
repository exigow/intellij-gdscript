import com.google.gson.Gson

object GodotApi {

    val CLASSES: Array<Class>

    init {
        val inputStream = this::class.java.classLoader.getResourceAsStream("api.json")!!.reader()
        CLASSES = Gson().fromJson<Array<Class>>(inputStream, Array<Class>::class.java)
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
