package tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File

open class GenerateLexer : DefaultTask() {

    @TaskAction
    fun run() {
        val files = parseClasses()
        val content = generateContent(files)
        saveFile(content)
    }

    private fun generateContent(classes: List<Document>) = """
        // Generated file. Local changes may be overwritten.
        lexer grammar $FILENAME;
        
        FUNCTION: ${collectFunctions(classes)};
        CONSTANT: ${collectConstants(classes)};
        
        """.trimIndent()

    private fun parseClasses() =
        File("${project.buildDir}/downloads").listFiles()!!
            .map { Jsoup.parse(it, "UTF-8") }

    private fun collectConstants(classes: List<Document>) =
        classes.first { it.selectName() == "@GlobalScope" }
            .select("constant")
            .map { it.attr("name") }
            .joined()

    private fun collectFunctions(classes: List<Document>) =
        classes.first { it.selectName() == "@GDScript" }
            .select("method")
            .map { it.attr("name") }
            .joined()

    private fun Document.selectName() =
        select("class").attr("name")

    private fun List<String>.joined(): String =
        filterNot { it.isBlank() }
            .distinct()
            .sorted()
            .joinToString(" | ") { "'$it'" }

    private fun saveFile(text: String) =
        File("src/main/antlr/gdscript/$FILENAME.g4")
            .writeText(text)

    companion object {

        const val FILENAME = "GeneratedLexer"

    }

}
