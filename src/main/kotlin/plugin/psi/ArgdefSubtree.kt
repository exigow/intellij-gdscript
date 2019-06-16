package plugin.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.tree.IElementType

class ArgdefSubtree(node: ASTNode, idElementType: IElementType) : VardefSubtree(node, idElementType)
