package classes.io

import classes.model.Class
import java.io.ByteArrayInputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


internal object ClassResourceLoader {

    fun loadZip(path: String): Set<Class> {
        val stream = ClassResourceLoader.javaClass.classLoader.getResourceAsStream(path)
        val zipStream = ZipInputStream(stream)
        val classes = mutableListOf<Class>()
        var entry = zipStream.nextEntry
        while (entry != null) {
            if (isXml(entry)) {
                val bytes = zipStream.readAllBytes()
                classes += ClassParser.parseXml(ByteArrayInputStream(bytes))
            }
            zipStream.closeEntry()
            entry = zipStream.nextEntry
        }
        return classes.toSet()
    }

    private fun isXml(entry: ZipEntry) =
        entry.size > 0 && entry.name.endsWith(".xml")

}