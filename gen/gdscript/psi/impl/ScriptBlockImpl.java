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

public class ScriptBlockImpl extends ScriptBaseElement implements ScriptBlock {

  public ScriptBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ScriptVisitor visitor) {
    visitor.visitBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ScriptVisitor) accept((ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ScriptAssertStatement> getAssertStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptAssertStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptAssignStatement> getAssignStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptAssignStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptAwaitStatement> getAwaitStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptAwaitStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptClassStatement> getClassStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptClassStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptClassnameStatement> getClassnameStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptClassnameStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptConstStatement> getConstStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptConstStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptElifStatement> getElifStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptElifStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptElseStatement> getElseStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptElseStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptEnumStatement> getEnumStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptEnumStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptExpressionStatement> getExpressionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptExpressionStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptExtendsStatement> getExtendsStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptExtendsStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptForStatement> getForStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptForStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptFuncStatement> getFuncStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptFuncStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptIconStatement> getIconStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptIconStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptIfStatement> getIfStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptIfStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptMatchLabelStatement> getMatchLabelStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptMatchLabelStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptMatchStatement> getMatchStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptMatchStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptReturnStatement> getReturnStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptReturnStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptSignalStatement> getSignalStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptSignalStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptToolStatement> getToolStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptToolStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptVarStatement> getVarStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptVarStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptWhileStatement> getWhileStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptWhileStatement.class);
  }

  @Override
  @NotNull
  public List<ScriptYieldStatement> getYieldStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptYieldStatement.class);
  }

}
