package gdscript.documentation

import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import gdscript.ScriptFileType
import gdscript.ScriptLanguage
import version.VersionService
import version.data.Class
import java.util.concurrent.ConcurrentHashMap

@Service
class ScriptGeneratedSourceFileService(
    private val project: Project
) {

    private val files: MutableMap<String, PsiFile> = ConcurrentHashMap()

    fun getSourceFile(className: String): PsiFile? {
        if (!files.containsKey(className)) {
            val clazz = findClass(className)
                ?: return null
            val file = createFile(clazz)
            files += className to file
            return file
        }
        return files[className]
    }

    private fun findClass(className: String): Class? {
        val current = VersionService.current()
        return (current.classes + current.singletons + current.primitives)
            .find { it.name == className }
    }

    private fun createFile(clazz: Class): PsiFile {
        val factory: PsiFileFactory = PsiFileFactory.getInstance(project)
        val code = generateCode(clazz)
        val filename = "${clazz.name}.${ScriptFileType.defaultExtension}"
        val file: PsiFile = factory.createFileFromText(filename, ScriptLanguage, code)
        file.viewProvider.document!!.setReadOnly(true)
        return file
    }

    private fun generateCode(clazz: Class): String {
        var result = ""
        result += "class_name ${clazz.name}\n"
        if (clazz.extends?.isNotEmpty() == true)
            result += "extends ${clazz.extends}\n"
        result += "\n# ${clazz.briefDescription}\n\n"

        // signals
        for (signal in clazz.signals)
            result += "signal ${signal.name}(" + signal.arguments.joinToString(", ") { it.name } + ")\n"
        if (clazz.signals.isNotEmpty())
            result += "\n"

        // constants
        for (constant in clazz.constants)
            result += "const ${constant.name} = ${constant.value}\n"
        if (clazz.constants.isNotEmpty())
            result += "\n"

        for (field in clazz.fields)
            result += "var ${field.name}: ${field.type}" + if (field.default != null) " = ${field.default}\n" else "\n"
        if (clazz.fields.isNotEmpty())
            result += "\n"

        // methods
        for (method in clazz.methods.filter { it.vararg == false }) {
            val methodName = if (clazz.name == method.name) "_init" else method.name
            result += "func $methodName(" + method.arguments.joinToString(", ") { "${it.name}: ${it.type}" } + ")"
            if (method.type.isNotEmpty() && method.type != "void")
                result += " -> ${method.type}"
            result += ": # native code\n"
        }
        if (clazz.methods.isNotEmpty())
            result += "\n"
        return result
    }

}