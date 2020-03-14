package gdscript.execution.filters

import com.intellij.execution.filters.Filter
import com.intellij.execution.filters.Filter.Result
import com.intellij.execution.filters.OpenFileHyperlinkInfo
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import kotlin.math.max

class LinkFilter(
    private val project: Project,
    private val workingDirectory: String
) : Filter {

    override fun applyFilter(textLine: String, endPoint: Int): Result? {
        val links = LinkParser.parseAll(textLine)
        if (links.isEmpty())
            return null
        val link = links.first() // todo: use all parsed links
        val file = findFile(link.file)
            ?: return null
        val fixedRange = link.range
            .move(endPoint - textLine.length)
            .moveLast()
        val fixedLine = moveLineUp(link.line)
        return Result(fixedRange.first, fixedRange.last, OpenFileHyperlinkInfo(project, file, fixedLine))
    }

    private fun findFile(relativePath: String): VirtualFile? =
        LocalFileSystem.getInstance()
            .findFileByPath("$workingDirectory/$relativePath")

    private fun IntRange.moveLast() =
        first..(last + 1)

    private fun IntRange.move(offset: Int) =
        (first + offset)..(last + offset)

    private fun moveLineUp(line: Int) =
        max(line - 1, 0)

}