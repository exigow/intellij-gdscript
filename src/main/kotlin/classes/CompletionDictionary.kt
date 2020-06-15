package classes

import classes.model.Class
import classes.model.Constant
import classes.model.Method
import com.google.gson.Gson

object CompletionDictionary {

    val ALL_CLASSES: List<Class>
    val SINGLETON_CLASSES: List<Class>
    val PRIMITIVE_CLASSES: List<Class>
    val GLOBAL_CONSTANTS: List<Constant>
    val GLOBAL_METHODS: List<Method>

    init {
        ALL_CLASSES = deserialize()
        SINGLETON_CLASSES = ALL_CLASSES.filter { it.name in collectSingletonNames() }
        GLOBAL_CONSTANTS = ALL_CLASSES.filter { isGlobal(it) }.flatMap { it.constants.orEmpty() }
        GLOBAL_METHODS = ALL_CLASSES.filter { isGlobal(it) }.flatMap { it.methods.orEmpty() }
        PRIMITIVE_CLASSES = ALL_CLASSES.filter { it.name in GDScriptGrammar.PRIMITIVE_KEYWORDS }
    }

    private fun collectSingletonNames() =
        ALL_CLASSES.filter { isGlobal(it) }.flatMap { it.fields.orEmpty() }.map { it.name }

    private fun isGlobal(clazz: Class) =
        clazz.name.startsWith("@")

    private fun deserialize(): List<Class> {
        val path = "completion.json"
        val stream = this::class.java.classLoader.getResourceAsStream(path)!!
        return Gson()
            .fromJson<Array<Class>>(stream.reader(), Array<Class>::class.java)
            .toList()
    }

}