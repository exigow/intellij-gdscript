package plugin.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class ArgdefSubtree extends VardefSubtree {
	public ArgdefSubtree(@NotNull ASTNode node, @NotNull IElementType idElementType) {
		super(node, idElementType);
	}
}
