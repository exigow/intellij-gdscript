package api.utils

import api.model.Class
import java.io.ByteArrayInputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

object ClassUnzipper {

    fun unzip(resourceName: String): List<Class> {
        val stream = loadResource(resourceName)
        val zipStream = ZipInputStream(stream)
        return readEntries(zipStream)
    }

    private fun loadResource(name: String) =
        this.javaClass.classLoader.getResourceAsStream(name)

    private fun readEntries(zip: ZipInputStream): List<Class> {
        val classes = mutableListOf<Class>()
        var entry = zip.nextEntry
        while (entry != null) {
            if (isXml(entry)) {
                val bytes = zip.readBytes()
                classes += ClassParser.parseXml(ByteArrayInputStream(bytes))
            }
            zip.closeEntry()
            entry = zip.nextEntry
        }
        return classes
    }

    private fun isXml(entry: ZipEntry) =
        entry.size > 0 && entry.name.endsWith(".xml")

}