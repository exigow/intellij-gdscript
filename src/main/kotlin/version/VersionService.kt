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
        loadVersion("3.2", "version/3.2.zip"),
        loadVersion("3.3", "version/3.3.zip"),
        loadVersion("3.4", "version/3.4.zip"),
        loadVersion("3.5", "version/3.5.zip"),
        loadVersion("4.0", "version/4.0.zip"),
        loadVersion("4.1", "version/4.1.zip"),
        Version("Disabled", emptyList(), emptyList(), emptyList(), emptyList())
    )

    private fun loadVersion(versionId: String, resourcePath: String): Version {
        val classes: List<Class> = readEntries(resourcePath)
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

        const val DEFAULT_VERSION = "4.1"

        fun current(): Version {
            val versionService = service<VersionService>().versions
            val settingsVersionId = service<ApplicationSettings>().versionId
            return versionService.find { it.versionId == settingsVersionId }
                ?: versionService.find { it.versionId == DEFAULT_VERSION }!!
        }

        fun all(): List<Version> =
            service<VersionService>().versions

    }

}