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

public class TscnValueImpl extends TscnBaseElement implements TscnValue {

  public TscnValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TscnVisitor visitor) {
    visitor.visitValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TscnVisitor) accept((TscnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TscnDictionaryExpression getDictionaryExpression() {
    return findChildByClass(TscnDictionaryExpression.class);
  }

  @Override
  @Nullable
  public TscnExtExpression getExtExpression() {
    return findChildByClass(TscnExtExpression.class);
  }

  @Override
  @Nullable
  public TscnFunctionExpression getFunctionExpression() {
    return findChildByClass(TscnFunctionExpression.class);
  }

  @Override
  @Nullable
  public TscnListExpression getListExpression() {
    return findChildByClass(TscnListExpression.class);
  }

  @Override
  @Nullable
  public TscnResourceString getResourceString() {
    return findChildByClass(TscnResourceString.class);
  }

  @Override
  @Nullable
  public TscnSubExpression getSubExpression() {
    return findChildByClass(TscnSubExpression.class);
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

}
