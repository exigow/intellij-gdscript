// This is a generated file. Not intended for manual editing.
package tscn.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tscn.psi.TscnBaseElement;
import tscn.psi.TscnSubExpression;
import tscn.psi.TscnVisitor;

import static tscn.psi.TscnElementTypes.*;

public class TscnSubExpressionImpl extends TscnBaseElement implements TscnSubExpression {

  public TscnSubExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TscnVisitor visitor) {
    visitor.visitSubExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TscnVisitor) accept((TscnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getDoubleQuotedString() {
    return findChildByType(DOUBLE_QUOTED_STRING);
  }

  @Override
  @Nullable
  public PsiElement getNumber() {
    return findChildByType(NUMBER);
  }

  @Override
  @Nullable
  public PsiElement getSingleQuotedString() {
    return findChildByType(SINGLE_QUOTED_STRING);
  }

  @Override
  @NotNull
  public PsiReference getReference() {
    return TscnPsiImplUtil.getReference(this);
  }

}
