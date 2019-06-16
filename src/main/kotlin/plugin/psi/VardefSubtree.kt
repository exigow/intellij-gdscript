package plugin.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree

open class VardefSubtree(node: ASTNode, idElementTyp: IElementType) : IdentifierDefSubtree(node, idElementTyp)
