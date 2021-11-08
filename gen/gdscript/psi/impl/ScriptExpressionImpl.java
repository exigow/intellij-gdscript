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

public class ScriptExpressionImpl extends ScriptBaseElement implements ScriptExpression {

  public ScriptExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ScriptVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ScriptVisitor) accept((ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ScriptArrayExpression> getArrayExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptArrayExpression.class);
  }

  @Override
  @NotNull
  public List<ScriptDictionaryExpression> getDictionaryExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptDictionaryExpression.class);
  }

  @Override
  @NotNull
  public List<ScriptId> getIdList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptId.class);
  }

  @Override
  @NotNull
  public List<ScriptInvocationExpression> getInvocationExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptInvocationExpression.class);
  }

  @Override
  @NotNull
  public List<ScriptLambdaExpression> getLambdaExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptLambdaExpression.class);
  }

  @Override
  @NotNull
  public List<ScriptLuaDictionaryExpression> getLuaDictionaryExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptLuaDictionaryExpression.class);
  }

  @Override
  @NotNull
  public List<ScriptString> getStringList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptString.class);
  }

}
