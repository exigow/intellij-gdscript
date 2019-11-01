package gdscript.utilities

import com.intellij.openapi.vfs.VirtualFile

object ProjectFileFinder {

    tailrec fun findProject(start: VirtualFile, maxDepth: Int = 3): VirtualFile? {
        if (maxDepth < 0 || start.parent == null)
            return null
        return findProjectChild(start)
            ?: findProject(start.parent, maxDepth - 1)
    }

    private fun findProjectChild(directory: VirtualFile) =
        directory.children.find { it.name == "project.godot" }

}