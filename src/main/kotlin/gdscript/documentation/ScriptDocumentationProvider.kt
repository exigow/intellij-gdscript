package gdscript.documentation

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup.*
import com.intellij.psi.PsiElement
import version.data.Argument
import version.VersionService
import version.data.Class

class ScriptDocumentationProvider : AbstractDocumentationProvider() {

    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        val clazz = findClass(originalElement)
            ?: return null
        return listOf(
            DEFINITION_START,
            clazz.name,
            DEFINITION_END,
            CONTENT_START,
            generateDocList("Properties", clazz.fields.map { it.name + if (it.default != null) " = ${it.default}" else "" }),
            generateDocList("Methods", clazz.methods.map { it.name + "(" + joinArguments(it.arguments) + ")" + if (it.type != "void") " -> ${it.type}" else "" }),
            generateDocList("Constants", clazz.constants.map { it.name + " = " + it.value }),
            generateDocList("Signals", clazz.signals.map { it.name + if (it.arguments.isNotEmpty()) "(" + joinArguments(it.arguments) + ")" else ""}),
            CONTENT_END
        ).joinToString("")
    }

    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        val clazz = findClass(originalElement)
            ?: return null
        val extends = if (clazz.extends?.isNotEmpty() == true) " extends ${clazz.extends}" else ""
        return "class ${clazz.name}" + extends
    }

    private fun findClass(element: PsiElement?): Class? {
        val current = VersionService.current()
        return (current.classes + current.singletons + current.primitives)
            .find { it.name == element?.text }
    }

    private fun joinArguments(arguments: List<Argument>) =
        arguments.joinToString(", ") { arg -> arg.name + ": " + arg.type }

    private fun generateDocList(title: String, list: List<String>): String =
        if (list.isEmpty())
            ""
        else
            "<h3>$title</h3><ul>${list.joinToString("") { "<li><code>$it</code></li>" }}</ul>"

}