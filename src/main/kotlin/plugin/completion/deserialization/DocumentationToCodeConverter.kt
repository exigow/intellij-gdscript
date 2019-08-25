package plugin.completion.deserialization

import plugin.completion.deserialization.models.Constant
import plugin.completion.deserialization.models.Documentation
import plugin.completion.deserialization.models.Member
import plugin.completion.deserialization.models.Method

// todo: refactor
// todo: remove extension methods
object DocumentationToCodeConverter {

    fun generate(doc: Documentation): String {
        val extends = doc.formatExtends()
        val name = doc.formatName()
        val constants = doc.constants?.joinToString("\n") { it.format() }
        val members = doc.members?.joinToString("\n") { it.format() }
        val methods = doc.methods?.joinToString("\n\n") { it.format() }
        return listOfNotNull(extends, name, constants, members, methods).joinToString("\n\n").trim()
    }

    private fun Documentation.formatExtends() = if (inherits != null) "extends $inherits" else null

    private fun Documentation.formatName() = "class_name $name"

    private fun Constant.format() = "const $name = $value"

    // todo: refactor
    private fun Member.format(): String {
        if (default == null)
            return "var $name: $type"
        return "var $name: $type = $default"
    }

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