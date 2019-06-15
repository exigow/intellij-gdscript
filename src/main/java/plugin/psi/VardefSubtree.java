package plugin.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree;
import org.jetbrains.annotations.NotNull;

public class VardefSubtree extends IdentifierDefSubtree {

	public VardefSubtree(@NotNull ASTNode node, @NotNull IElementType idElementTyp) {
		super(node, idElementTyp);
	}
}
