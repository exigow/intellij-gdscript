@file:JvmName("main")

import com.google.gson.GsonBuilder
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import org.jsoup.Jsoup.connect
import org.jsoup.nodes.Document
import java.io.File
import java.util.concurrent.atomic.AtomicInteger


suspend fun main() {
    val listPage = downloadListPage()
    val links = collectLinks(listPage)
    val counter = AtomicInteger()
    val sdk = Library(classes = coroutineScope {
        links.map {
            async {
                println("${counter.incrementAndGet()}/${links.size} $it")
                process(it)
            }
        }.awaitAll()
        }.toList()
        .sortedBy { it.name }
    )
    serialize(sdk)
}

private fun downloadListPage(): Document =
    connect("https://github.com/godotengine/godot/tree/master/doc/classes").get()

private fun collectLinks(listPage: Document) =
    listPage.select("a[title$=.xml]")
        .map { it.absUrl("href") }
        .map { it.replace("blob", "raw") }

private fun process(link: String): Library.Class {
    val xml = connect(link).get()
    return parse(xml)
}

private fun parse(xml: Document) = Library.Class(
    name = xml.select("class").attr("name"),
    extends = xml.select("class").attr("inherits"),
    description = xml.select("brief_description").text().trimIndent().trim(),
    fields = xml.select("member").map { field ->
        Library.Class.Field(
            name = field.attr("name"),
            type = field.attr("type"),
            setter = field.attr("setter"),
            getter = field.attr("getter"),
            default = field.attr("default")
        )
    },
    methods = xml.select("method").map { method ->
        Library.Class.Method(
            name = method.attr("name"),
            type = method.select("return").attr("type"),
            arguments = method.select("argument")
                .sortedBy { it.attr("index") }
                .map { argument ->
                    Library.Class.Method.Argument(
                        name = argument.attr("name"),
                        type = argument.attr("type")
                    )
                }
        )
    },
    constants = xml.select("constant").map { constant ->
        Library.Class.Constant(
            name = constant.attr("name"),
            value = constant.attr("value")
        )
    }
)

fun serialize(lib: Library) {
    val writer = File("shared/src/main/resources/library.json").writer()
    val gson = GsonBuilder().setPrettyPrinting().create()
    gson.toJson(lib, writer)
    writer.flush()
}