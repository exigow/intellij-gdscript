package classes

import classes.model.Class
import com.google.gson.Gson

object CompletionDictionary {

    val CLASSES = deserialize()
    val SINGLETONS = CLASSES.filter { it.name in collectSingletonNames() }
    val LANGUAGE_CONSTANTS = CLASSES.filter { isGlobal(it) }.flatMap { it.constants.orEmpty() }
    val LANGUAGE_CONSTANT_NAMES = LANGUAGE_CONSTANTS.map { it.name }.toSet()
    val FUNCTIONS = CLASSES.filter { isGlobal(it) }.flatMap { it.methods.orEmpty() }
    val FUNCTION_NAMES = FUNCTIONS.map { it.name }.toSet()
    val PRIMITIVES = CLASSES.filter { it.name in GDScriptGrammar.PRIMITIVE_KEYWORDS }.toTypedArray()
    val NON_PRIMITIVE_CLASS_NAMES = (CLASSES.toList() - PRIMITIVES).map { it.name }.toSet()
    val CLASS_CONSTRUCTORS = toConstructors(CLASSES)
    val PRIMITIVE_CONSTRUCTORS = toConstructors(PRIMITIVES)

    private fun collectSingletonNames() =
        CLASSES.filter { isGlobal(it) }.flatMap { it.fields.orEmpty() }.map { it.name }

    private fun toConstructors(classes: Array<Class>) =
        classes.flatMap { c -> c.methods?.filter { it -> c.name == it.name }.orEmpty() }

    private fun isGlobal(clazz: Class) =
        clazz.name.startsWith("@")

    private fun deserialize(): Array<Class> {
        val path = "completion.json"
        val stream = this::class.java.classLoader.getResourceAsStream(path)!!
        return Gson().fromJson<Array<Class>>(stream.reader(), Array<Class>::class.java)
    }

}