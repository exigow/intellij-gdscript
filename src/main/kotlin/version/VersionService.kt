package version

import version.data.Class
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import gdscript.lexer.ScriptKeywords
import org.jsoup.Jsoup
import settings.ApplicationSettings
import version.data.Version
import java.io.ByteArrayInputStream
import java.util.zip.ZipInputStream

@Service
class VersionService {

    private val versions: List<Version> = listOf(
        loadResource("3.2.2", "version/3.2.2-rc.zip"),
        loadResource("3.3.3", "version/3.3.3-rc.zip"),
        loadResource("4.0", "version/4.0.0-dev.zip"),
        Version("Disabled", emptyList(), emptyList(), emptyList(), emptyList())
    )

    private fun loadResource(displayName: String, path: String): Version {
        val classes: List<Class> = readEntries(path)
        val (primitives, nonPrimitives) = classes.partition { it.name in ScriptKeywords.PRIMITIVES }
        val (globals, nonGlobals) = nonPrimitives.partition { it.name.startsWith("@") }
        val singletonNames = globals.flatMap { it.fields }.map { it.name }
        val (singletons, instanced) = nonGlobals.partition { it.name in singletonNames }
        return Version(displayName, instanced, primitives, singletons, globals)
    }

    private fun readEntries(path: String): List<Class> {
        val zip = ZipInputStream(javaClass.classLoader.getResourceAsStream(path)!!)
        val classes = mutableListOf<Class>()
        var entry = zip.nextEntry
        while (entry != null) {
            if (entry.size > 0 && entry.name.endsWith(".xml")) {
                val byteStream = ByteArrayInputStream(zip.readBytes())
                val doc = Jsoup.parse(byteStream, null, "")
                classes += parseClass(doc)
            }
            zip.closeEntry()
            entry = zip.nextEntry
        }
        return classes
    }

    companion object {

        fun current(): Version {
            val versionService = service<VersionService>().versions
            val name = service<ApplicationSettings>().apiVersion
            return versionService.find { it.version == name }
                ?: versionService.first()
        }

        fun all() = service<VersionService>().versions

    }

}