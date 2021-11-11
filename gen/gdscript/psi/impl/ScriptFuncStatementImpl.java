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

public class ScriptFuncStatementImpl extends ScriptBaseElement implements ScriptFuncStatement {

  public ScriptFuncStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ScriptVisitor visitor) {
    visitor.visitFuncStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ScriptVisitor) accept((ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ScriptBlock getBlock() {
    return findNotNullChildByClass(ScriptBlock.class);
  }

  @Override
  @NotNull
  public List<ScriptFuncArgument> getFuncArgumentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptFuncArgument.class);
  }

  @Override
  @NotNull
  public ScriptId getId() {
    return findNotNullChildByClass(ScriptId.class);
  }

  @Override
  @Nullable
  public ScriptType getType() {
    return findChildByClass(ScriptType.class);
  }

}
