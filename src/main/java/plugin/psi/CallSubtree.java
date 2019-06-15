package plugin.psi;

import com.intellij.lang.ASTNode;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;

public class CallSubtree extends ANTLRPsiNode {
	public CallSubtree(@NotNull ASTNode node) {
		super(node);
	}
}
