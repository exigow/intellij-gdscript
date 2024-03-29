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
import com.intellij.psi.PsiReference;

public class ScriptIdImpl extends ScriptBaseElement implements ScriptId {

  public ScriptIdImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ScriptVisitor visitor) {
    visitor.visitId(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ScriptVisitor) accept((ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getNodePath() {
    return findChildByType(NODE_PATH);
  }

  @Override
  @NotNull
  public PsiReference getReference() {
    return ScriptPsiImplUtil.getReference(this);
  }

}
