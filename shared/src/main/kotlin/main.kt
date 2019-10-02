@file:JvmName("main")

import com.google.gson.GsonBuilder
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import org.jsoup.Jsoup.connect
import org.jsoup.nodes.Document
import java.io.File


suspend fun main() {
    val directory = fetch("https://github.com/godotengine/godot/tree/master/doc/classes")
    val links = collectLinks(directory) + "https://github.com/godotengine/godot/raw/master/modules/gdscript/doc_classes/@GDScript.xml"
    val classes = coroutineScope {
        links.sorted()
            .map { async { parse(fetch(it)) } }
            .awaitAll()
        }.toTypedArray()
    serializeToFile(classes)
}

private fun fetch(url: String): Document {
    println(url)
    return connect(url).get()
}

private fun collectLinks(listPage: Document) =
    listPage.select("a[title$=.xml]")
        .map { it.absUrl("href") }
        .map { it.replace("blob", "raw") }

private fun serializeToFile(library: Array<Library.Class>) {
    val writer = File("src/main/resources/library.json").writer()
    GsonBuilder()
        .setPrettyPrinting()
        .create()
        .toJson(library, writer)
    writer.flush()
}