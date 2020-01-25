package tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import tasks.serializer.ApiSerializer
import java.io.File

open class GenerateCompletion : DefaultTask() {

    @TaskAction
    fun run() {
        val files = openFiles()
            .map { Jsoup.parse(it, "UTF-8") }
        val parsed = files
            .filter { hasClassName(it) }
            .map { parseClass(it) } + VOID_CLASS
        val classes = parsed.sortedBy { it.name }
        ApiSerializer.serialize(classes, "src/main/resources/completion.json")
    }

    private fun openFiles() =
        File("${project.buildDir}/downloads").listFiles()!!

    private fun hasClassName(file: Element) =
        file.select("class").attr("name").isNotEmpty()

    private fun parseClass(file: Element) =
        Class(
            file.select("class").attr("name"),
            file.select("class").attr("inherits"),
            file.select("member").map { parseField(it) },
            file.select("method").map { parseMethod(it) },
            file.select("constant").map { parseConstant(it) }
        )

    private fun parseField(field: Element) =
        Field(
            field.attr("name"),
            field.attr("type"),
            field.attr("setter"),
            field.attr("getter"),
            field.attr("default")
        )

    private fun parseMethod(method: Element) =
        Method(
            method.attr("name"),
            method.select("return").attr("type"),
            method.select("argument")
                .sortedBy { it.attr("index") }
                .map { Argument(it.attr("name"), it.attr("type")) },
            method.attr("qualifiers") == "vararg"
        )

    private fun parseConstant(constant: Element) =
        Constant(constant.attr("name"), constant.attr("value"))

    private companion object {

        val VOID_CLASS = Class("void", null, emptyList(), emptyList(), emptyList())

    }
}
