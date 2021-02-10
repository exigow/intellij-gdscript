package api

import api.model.Class
import api.utils.ClassUnzipper
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import settings.ApplicationSettings

@Service
class VersionedClassesService {

    val versions: List<VersionedClasses> = listOf(
        loadResource("3.2.2", "api/3.2.2-rc.zip"),
        loadResource("4.0", "api/4.0.0-dev.zip"),
        VersionedClasses("Disabled", emptyList(), emptyList(), emptyList(), emptyList())
    )

    fun current(): VersionedClasses {
        val name = service<ApplicationSettings>().apiVersion
        return versions.find { it.name == name }
            ?: versions[0]
    }

    private fun loadResource(displayName: String, path: String): VersionedClasses {
        val classes: List<Class> = ClassUnzipper.unzip(path)
        val (primitives, nonPrimitives) = classes.partition { it.name in listOf("float", "int", "bool", "void") }
        val (globals, nonGlobals) = nonPrimitives.partition(::isGlobal)
        val singletonNames = globals.flatMap { it.fields }.map { it.name }
        val (singletons, instanced) = nonGlobals.partition { it.name in singletonNames }
        return VersionedClasses(displayName, instanced, primitives, singletons, globals)
    }

    private fun isGlobal(clazz: Class) =
        clazz.name.startsWith("@")

    data class VersionedClasses(
        val name: String,
        val classes: List<Class>,
        val primitives: List<Class>,
        val singletons: List<Class>,
        val globals: List<Class>
    )

}