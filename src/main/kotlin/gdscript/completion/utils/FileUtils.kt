package gdscript.completion.utils

import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileVisitor

object FileUtils {

    fun collectPathsToProjectFiles(
        currentFile: VirtualFile,
        isUseful: (VirtualFile) -> Boolean = { true }
    ): Map<String, VirtualFile> {
        val closestProject = findProjectFile(currentFile)
            ?: return emptyMap()
        val projectDirectory = closestProject.parent
        val files = collectAllSubdirectoryFiles(projectDirectory, isUseful)
        return files
            .map { file -> VfsUtilCore.findRelativePath(closestProject, file, '/')!! to file }
            .toMap()
    }

    private tailrec fun findProjectFile(
        start: VirtualFile,
        maxDepth: Int = 3
    ): VirtualFile? {
        if (maxDepth < 0 || start.parent == null)
            return null
        return findProjectChild(start)
            ?: findProjectFile(start.parent, maxDepth - 1)
    }

    private fun collectAllSubdirectoryFiles(
        start: VirtualFile,
        isUseful: (VirtualFile) -> Boolean
    ): Collection<VirtualFile> {
        val list = ArrayList<VirtualFile>()
        VfsUtilCore.visitChildrenRecursively(start, object : VirtualFileVisitor<Any>() {
            override fun visitFile(file: VirtualFile): Boolean {
                if (file.isDirectory && !isUseful(file))
                    return false
                if (!file.isDirectory && isUseful(file))
                    list.add(file)
                return super.visitFile(file)
            }
        })
        return list
    }

    private fun findProjectChild(directory: VirtualFile) =
        directory.children.find { it.name == "project.godot" }

}