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

public class TscnListExpressionImpl extends TscnBaseElement implements TscnListExpression {

  public TscnListExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TscnVisitor visitor) {
    visitor.visitListExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TscnVisitor) accept((TscnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TscnDictionaryExpression> getDictionaryExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TscnDictionaryExpression.class);
  }

  @Override
  @NotNull
  public List<TscnExtExpression> getExtExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TscnExtExpression.class);
  }

  @Override
  @NotNull
  public List<TscnFunctionExpression> getFunctionExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TscnFunctionExpression.class);
  }

  @Override
  @NotNull
  public List<TscnListExpression> getListExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TscnListExpression.class);
  }

  @Override
  @NotNull
  public List<TscnResourceString> getResourceStringList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TscnResourceString.class);
  }

  @Override
  @NotNull
  public List<TscnSubExpression> getSubExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TscnSubExpression.class);
  }

}
