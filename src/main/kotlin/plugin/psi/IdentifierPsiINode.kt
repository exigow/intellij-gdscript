package plugin.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference
import com.intellij.psi.tree.IElementType
import com.intellij.util.IncorrectOperationException
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiLeafNode
import org.antlr.intellij.adaptor.psi.Trees
import plugin.GDScript
import plugin.GDScriptParserDefinition
import org.jetbrains.annotations.NonNls
import plugin.parser.GDScriptParser.*

/** From doc: "Every element which can be renamed or referenced
 * needs to implement com.intellij.psi.PsiNamedElement interface."
 *
 * So, all leaf nodes that represent variables, functions, classes, or
 * whatever in your plugin language must be instances of this not just
 * LeafPsiElement.  Your ASTFactory should create this kind of object for
 * IDENTIFIER tokens. This node is for references *and* definitions because you can
 * highlight a function and say "jump to definition". Also we want defs
 * to be included in "find usages." Besides, there is no context information
 * in the AST factory with which you could decide whether this node
 * is a definition or a reference.
 *
 * PsiNameIdentifierOwner (vs PsiNamedElement) implementations are the
 * corresponding subtree roots that define symbols.
 *
 * You can click on an IDENTIFIER in the editor and ask for a rename for any node
 * of this type.
 */
class IdentifierPsiINode(type: IElementType, text: CharSequence) : ANTLRPsiLeafNode(type, text), PsiNamedElement {

    override fun getName() = text

    /** Alter this node to have text specified by the argument. Do this by
     * creating a new node through parsing of an IDENTIFIER and then doing a
     * replace.
     */
    @Throws(IncorrectOperationException::class)
    override fun setName(@NonNls name: String): PsiElement {
        if (parent == null) return this // weird but it happened once
        /*
		IElementType elType = getParent().getNode().getElementType();
		String kind = "??? ";
		if ( elType instanceof RuleIElementType ) {
			int ruleIndex = ((RuleIElementType) elType).getRuleIndex();
			if ( ruleIndex == RULE_call_expr ) {
				kind = "call ";
			}
			else if ( ruleIndex == RULE_statement ) {
				kind = "assign ";
			}
			else if ( ruleIndex == RULE_function ) {
				kind = "func def ";
			}
		}
		System.out.println("IdentifierPsiINode.setName("+name+") on "+
			                   kind+this+" at "+Integer.toHexString(this.hashCode()));
		*/
        val newID = Trees.createLeafFromText(project,
                GDScript,
                context,
                name,
                GDScriptParserDefinition.ID)
        return if (newID != null) {
            this.replace(newID) // use replace on leaves but replaceChild on IDENTIFIER nodes that are part of defs/decls.
        } else this
    }

    /** Create and return a PsiReference object associated with this IDENTIFIER
     * node. The reference object will be asked to resolve this ref
     * by using the text of this node to identify the appropriate definition
     * site. The definition site is typically a subtree for a function
     * or variable definition whereas this reference is just to this IDENTIFIER
     * leaf node.
     *
     * As the AST factory has no context and cannot create different kinds
     * of PsiNamedElement nodes according to context, every IDENTIFIER node
     * in the tree will be of this type. So, we distinguish references
     * from definitions or other uses by looking at context in this method
     * as we have parent (context) information.
     */
    override fun getReference(): PsiReference? {
        val parent = parent
        val elType = parent.node.elementType
        // do not return a reference for the IDENTIFIER nodes in a definition
        if (elType is RuleIElementType) {
            when (elType.ruleIndex) {
                RULE_statement, RULE_expression, RULE_primary -> return VariableReference(this)
                RULE_call_function_expression -> return FunctionReference(this)
            }
        }
        return null
    }
}
