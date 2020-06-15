package classes

import classes.io.ClassResourceLoader
import classes.model.Class
import classes.model.Constant
import classes.model.Method

object CompletionDictionary {

    val INSTANCED_CLASSES: List<Class>
    val SINGLETON_CLASSES: List<Class>
    val PRIMITIVE_CLASSES: List<Class>
    val GLOBAL_CONSTANTS: List<Constant>
    val GLOBAL_METHODS: List<Method>

    init {
        val all = ClassResourceLoader.loadZip("classes/v3.2.zip")
        val (globals, nonGlobals) = all.partition { it.name.startsWith("@") }
        val singletonNames = globals.flatMap { it.fields.orEmpty() }.map { it.name }
        val (singletons, instanced) = nonGlobals.partition { it.name in singletonNames }
        INSTANCED_CLASSES = instanced
        SINGLETON_CLASSES = singletons
        PRIMITIVE_CLASSES = nonGlobals.filter { it.name in GDScriptGrammar.PRIMITIVE_KEYWORDS }
        GLOBAL_CONSTANTS = globals.flatMap { it.constants.orEmpty() }
        GLOBAL_METHODS = globals.flatMap { it.methods.orEmpty() }
    }

}