package projectView

import com.intellij.ide.projectView.ProjectViewSettings
import com.intellij.ide.projectView.TreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.NestingTreeNode
import com.intellij.ide.projectView.impl.nodes.PsiFileNode
import com.intellij.ide.util.treeView.AbstractTreeNode

class ImportFileTreeStructureProvider : TreeStructureProvider {

    override fun modify(
        parent: AbstractTreeNode<*>,
        children: MutableCollection<AbstractTreeNode<*>>,
        settings: ViewSettings?
    ): MutableCollection<AbstractTreeNode<*>> {
        if (settings is ProjectViewSettings && !settings.isUseFileNestingRules) {
            return children
        }

        val newChildren = mutableListOf<AbstractTreeNode<*>>()
        val nodesByFilename = children
            .mapNotNull { child -> child as? PsiFileNode }
            .associateBy { child -> child.virtualFile?.name }

        for (child in children) {
            if (child !is PsiFileNode) {
                newChildren.add(child)
                continue
            }

            val filename = child.virtualFile?.name

            if (filename == null) {
                newChildren.add(child)
                continue
            }

            // Skip "x.png.import" when "x.png" is a sibling
            if (filename.endsWith(".import") && filename.removeSuffix(".import") in nodesByFilename) {
                continue
            }

            val siblingToNest = nodesByFilename["$filename.import"]

            // Replace "x.png" with a nested node containing "x.png.import"
            if (siblingToNest != null) {
                val nested = NestingTreeNode(child, arrayListOf(siblingToNest))
                newChildren.add(nested as AbstractTreeNode<*>)
            } else {
                newChildren.add(child)
            }
        }

        return newChildren
    }
}