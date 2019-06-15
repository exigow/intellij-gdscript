package plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/** A reference object associated with (referring to) a IdentifierPsiINode
 *  underneath a call_expr rule subtree root.
 */
public class FunctionRef extends GDScriptElementRef {
	public FunctionRef(@NotNull IdentifierPsiINode element) {
		super(element);
	}

	@Override
	public boolean isDefSubtree(PsiElement def) {
		return def instanceof FunctionSubtree;
	}
}
