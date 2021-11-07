package version

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import org.jsoup.Jsoup
import settings.ApplicationSettings
import version.data.Class
import version.data.Version
import java.io.ByteArrayInputStream
import java.util.zip.ZipInputStream

@Service
class VersionService {

    private val versions: List<Version> = listOf(
        loadResource("3.2", "version/3.2.zip"),
        loadResource("3.3", "version/3.3.zip"),
        loadResource("3.4", "version/3.4.zip"),
        loadResource("4.0", "version/4.0.zip"),
        Version("Disabled", emptyList(), emptyList(), emptyList(), emptyList())
    )

    private fun loadResource(versionId: String, path: String): Version {
        val classes: List<Class> = readEntries(path)
        val (primitives, nonPrimitives) = classes.partition { it.name in listOf("float", "int", "bool", "void") }
        val (globals, nonGlobals) = nonPrimitives.partition { it.name.startsWith("@") }
        val singletonNames = globals.flatMap { it.fields }.map { it.name }
        val (singletons, instanced) = nonGlobals.partition { it.name in singletonNames }
        return Version(versionId, instanced, primitives, singletons, globals)
    }

    private fun readEntries(path: String): List<Class> {
        val zip = ZipInputStream(javaClass.classLoader.getResourceAsStream(path)!!)
        val classes = mutableListOf<Class>()
        var entry = zip.nextEntry
        while (entry != null) {
            if (entry.size > 0 && entry.name.endsWith(".xml")) {
                val byteStream = ByteArrayInputStream(zip.readBytes())
                val doc = Jsoup.parse(byteStream, "UTF-8", "")
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
            val settingsVersionId = service<ApplicationSettings>().versionId
            return versionService.find { it.versionId == settingsVersionId }
                ?: versionService.first()
        }

        fun all(): List<Version> =
            service<VersionService>().versions

    }

}