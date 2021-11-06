// This is a generated file. Not intended for manual editing.
package gdscript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static gdscript.psi.ScriptElementTypes.*;
import gdscript.psi.ScriptBaseElement;
import gdscript.psi.*;

public class ScriptAssignStatementImpl extends ScriptBaseElement implements ScriptAssignStatement {

  public ScriptAssignStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ScriptVisitor visitor) {
    visitor.visitAssignStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ScriptVisitor) accept((ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptExpression.class);
  }

}
