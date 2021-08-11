// This is a generated file. Not intended for manual editing.
package tscn.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tscn.psi.TscnElementTypes.*;
import tscn.psi.TscnBaseElement;
import tscn.psi.*;
import com.intellij.psi.PsiReference;

public class TscnResourceStringImpl extends TscnBaseElement implements TscnResourceString {

  public TscnResourceStringImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TscnVisitor visitor) {
    visitor.visitResourceString(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TscnVisitor) accept((TscnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getDoubleQuotedResourceString() {
    return findChildByType(DOUBLE_QUOTED_RESOURCE_STRING);
  }

  @Override
  @Nullable
  public PsiElement getSingleQuotedResourceString() {
    return findChildByType(SINGLE_QUOTED_RESOURCE_STRING);
  }

  @Override
  @NotNull
  public PsiReference getReference() {
    return TscnPsiImplUtil.getReference(this);
  }

}
