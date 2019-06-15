package plugin.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.SymtabUtils;
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree;
import org.antlr.intellij.adaptor.psi.ScopeNode;
import plugin.GDScriptLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** A subtree associated with a function definition.
 *  Its scope is the set of arguments.
 */
public class FunctionSubtree extends IdentifierDefSubtree implements ScopeNode {
	public FunctionSubtree(@NotNull ASTNode node, @NotNull IElementType idElementType) {
		super(node, idElementType);
	}

	@Nullable
	@Override
	public PsiElement resolve(PsiNamedElement element) {
//		System.out.println(getClass().getSimpleName()+
//			                   ".resolve("+myElement.getName()+
//			                   " at "+Integer.toHexString(myElement.hashCode())+")");
		return SymtabUtils.resolve(this, GDScriptLanguage.INSTANCE,
		                           element, "/script/function/ID");
	}
}
