package run.console

import com.intellij.execution.filters.Filter
import com.intellij.execution.filters.Filter.Result
import com.intellij.execution.filters.OpenFileHyperlinkInfo
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import kotlin.math.max

class ConsoleLinkFilter(
    private val project: Project,
    private val workingDirectory: String
) : Filter {

    override fun applyFilter(textLine: String, endPoint: Int): Result? {
        val links = ConsoleLinkParser.parseText(textLine)
        if (links.isEmpty())
            return null
        val link = links.first() // todo use all
        val file = findFile(link.file)
            ?: return null
        val offset = endPoint - textLine.length
        val from = link.range.first + offset
        val to = link.range.last + offset + 1
        val fileLink = OpenFileHyperlinkInfo(project, file, max(link.line - 1, 0))
        return Result(from, to, fileLink)
    }

    private fun findFile(relativePath: String): VirtualFile? =
        LocalFileSystem.getInstance()
            .findFileByPath("$workingDirectory/$relativePath")

}