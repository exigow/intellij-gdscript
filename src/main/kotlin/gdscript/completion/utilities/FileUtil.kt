package gdscript.completion.utilities

import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileVisitor
import java.util.ArrayList


object FileUtil {

    fun collectAllFiles(start: VirtualFile): Collection<VirtualFile> {
        val list = ArrayList<VirtualFile>()
        VfsUtilCore.visitChildrenRecursively(start, object : VirtualFileVisitor<Any>() {
            override fun visitFile(file: VirtualFile): Boolean {
                if (file.isHidden())
                    return false
                if (!file.isDirectory && file.extension != "import")
                    list.add(file)
                return super.visitFile(file)
            }
        })
        return list
    }

    private fun VirtualFile.isHidden() = name.startsWith(".")

    tailrec fun findProjectFile(start: VirtualFile, maxSearchDepth: Int = 3): VirtualFile? {
        val project = start.children.find { it.name == "project.godot" }
        if (project != null)
            return project
        if (maxSearchDepth < 0 || start.parent == null)
            return null
        return findProjectFile(start.parent, maxSearchDepth - 1)
    }

}