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

public class TscnSubEntryImpl extends TscnBaseElement implements TscnSubEntry {

  public TscnSubEntryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TscnVisitor visitor) {
    visitor.visitSubEntry(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TscnVisitor) accept((TscnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TscnAttribute> getAttributeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TscnAttribute.class);
  }

  @Override
  @NotNull
  public List<TscnProperty> getPropertyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TscnProperty.class);
  }

}
