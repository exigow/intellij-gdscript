import com.google.gson.GsonBuilder
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.register
import org.jsoup.Jsoup.connect
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.io.File

open class GenerateDocumentationTask : DefaultTask() {

    init {
        group = "My"
        description = "Prints a description of ${JSON_LOCATION}."
    }

    @TaskAction
    fun run() {
        val directory = fetch("https://github.com/godotengine/godot/tree/master/doc/classes")
        val links = collectLinks(directory) + "https://github.com/godotengine/godot/raw/master/modules/gdscript/doc_classes/@GDScript.xml"
        val classes = links.sorted().subList(0, 5).map { parse(fetch(it)) }
        serializeToFile(classes)
        println("\nGenerated file location: $JSON_LOCATION")
    }

    private fun fetch(url: String): Document {
        println(url)
        return connect(url).get()
    }

    private fun collectLinks(listPage: Document) =
        listPage.select("a[title$=.xml]")
            .map { it.absUrl("href") }
            .map { it.replace("blob", "raw") }

    private fun serializeToFile(library: List<CompletionData.Class>) {
        val writer = File(JSON_LOCATION).writer()
        GsonBuilder()
            .setPrettyPrinting()
            .create()
            .toJson(library, writer)
        writer.flush()
    }

    companion object {
        const val JSON_LOCATION = "src/main/resources/api.json"
    }

    fun parse(xml: Element) = CompletionData.Class(
        name = xml.select("class").attr("name"),
        extends = xml.select("class").attr("inherits"),
        description = xml.select("brief_description").text().trimIndent().trim(),
        fields = xml.select("member").map { parseField(it) },
        methods = xml.select("method").map { parseMethod(it) },
        constants = xml.select("constant").map { parseConstant(it) }
    )

    private fun parseMethod(method: Element) =
        CompletionData.Class.Method(
            name = method.attr("name"),
            type = method.select("return").attr("type"),
            arguments = method.select("argument")
                .sortedBy { it.attr("index") }
                .map { argument ->
                    CompletionData.Class.Method.Argument(
                        name = argument.attr("name"),
                        type = argument.attr("type")
                    )
                }
        )

    private fun parseConstant(constant: Element) =
        CompletionData.Class.Constant(
            name = constant.attr("name"),
            value = constant.attr("value")
        )

    private fun parseField(field: Element) =
        CompletionData.Class.Field(
            name = field.attr("name"),
            type = field.attr("type"),
            setter = field.attr("setter"),
            getter = field.attr("getter"),
            default = field.attr("default")
        )

}

fun Project.registerGenerateCompletionDataTask() =
    tasks.register<GenerateDocumentationTask>("generateCompletion")
