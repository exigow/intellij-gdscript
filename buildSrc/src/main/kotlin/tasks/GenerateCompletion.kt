package tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File

open class GenerateCompletion : DefaultTask() {

    @TaskAction
    fun run() {
        val downloadsDirectory = File("${project.buildDir}/downloads")
        val files = downloadsDirectory
            .listFiles()!!
            .map { Jsoup.parse(it, "UTF-8") }
        val singletonNames = files
            .filter { isLanguageClass(it) }
            .flatMap { parseFields(it) }
            .map { it.name }
        val language = Language(
            constants = files
                .filter { isLanguageClass(it) }
                .flatMap { collectConstants(it) }
                .sortedBy { it.name },
            classes = files
                .filter { !isLanguageClass(it) }
                .filter { it.select("class").attr("name") !in singletonNames }
                .filter { isNotEmptyClass(it) }
                .map { parseClass(it) }
                .sortedBy { it.name },
            functions = files
                .filter { isLanguageClass(it) }
                .flatMap { parseMethods(it) }
                .sortedBy { it.name },
            singletons = files
                .filter { it.select("class").attr("name") in singletonNames }
                .map { parseClass(it) },
            primitiveClasses = files
                .filter { isPrimitiveClass(it) }
                .map { parseClass(it) }
                .sortedBy { it.name }
        )
        serialize(language, "src/main/resources/completion.json")
    }

    private fun isLanguageClass(file: Document) = file
        .select("class")
        .attr("name").startsWith("@")

    private fun isNotEmptyClass(file: Document) = file
        .select("class")
        .attr("name").isNotEmpty()

    private fun isPrimitiveClass(file: Document) = file
        .select("class")
        .attr("name") in listOf("bool", "float", "void", "int")

    private fun collectConstants(file: Document) = file
        .select("constant")
        .map { Constant(it.attr("name"), it.attr("value")) }

    private fun parseClass(file: Document) = Class(
        name = file.select("class").attr("name"),
        extends = file.select("class").attr("inherits"),
        description = file.select("brief_description").text().trimIndent().trim(),
        fields = parseFields(file),
        methods = parseMethods(file),
        constants = collectConstants(file)
    )

    private fun parseMethods(file: Document) = file
        .select("method")
        .map {
            Method(
                name = it.attr("name"),
                type = it.select("return").attr("type"),
                arguments = it.select("argument")
                    .sortedBy { argument -> argument.attr("index") }
                    .map { argument ->
                        Argument(
                            name = argument.attr("name"),
                            type = argument.attr("type")
                        )
                    }
            )
        }


    private fun parseFields(file: Document) = file
        .select("member")
        .map { field ->
            Field(
                name = field.attr("name"),
                type = field.attr("type"),
                setter = field.attr("setter"),
                getter = field.attr("getter"),
                default = field.attr("default")
            )
        }

}
