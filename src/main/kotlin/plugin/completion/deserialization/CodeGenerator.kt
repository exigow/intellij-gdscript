package plugin.completion.deserialization

import plugin.completion.deserialization.models.Constant
import plugin.completion.deserialization.models.Document
import plugin.completion.deserialization.models.Member
import plugin.completion.deserialization.models.Method

object CodeGenerator {

    fun generate(doc: Document): String {
        val headers = doc.formatHeaders()
        val constants = doc.constants?.joinToString("\n") { it.format() }
        val members = doc.members?.joinToString("\n") { it.format() }
        val methods = doc.methods?.joinToString("\n\n") { it.format() }
        return listOf(headers, constants, members, methods).joinToString("\n\n")
    }

    private fun Document.formatHeaders() = """
        extends $inherits
        class_name $name
        """.trimIndent()

    private fun Constant.format() = "const $name = $value"

    private fun Member.format() = "var $name: $type = $default"

    private fun Method.format() = """
        # ${sanitize(description.orEmpty().trim().split("\n")[0])}
        func $name(param1, param2) -> ${returnType?.type}:
            pass
        """.trimIndent()

    private fun sanitize(description: String) = description
        .sanitizeTags("code", "`")
        .sanitizeTags("b", "*")

    private fun String.sanitizeTags(tag: String, replaceWith: String) = replace("\\[/?$tag]".toRegex(), replaceWith)

}