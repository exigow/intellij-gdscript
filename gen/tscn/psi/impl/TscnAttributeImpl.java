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

public class TscnAttributeImpl extends TscnBaseElement implements TscnAttribute {

  public TscnAttributeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TscnVisitor visitor) {
    visitor.visitAttribute(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TscnVisitor) accept((TscnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public TscnKey getKey() {
    return findNotNullChildByClass(TscnKey.class);
  }

  @Override
  @NotNull
  public TscnValue getValue() {
    return findNotNullChildByClass(TscnValue.class);
  }

}
