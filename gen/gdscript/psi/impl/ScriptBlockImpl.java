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
  @Nullable
  public ScriptAssertStatement getAssertStatement() {
    return findChildByClass(ScriptAssertStatement.class);
  }

  @Override
  @Nullable
  public ScriptAssignStatement getAssignStatement() {
    return findChildByClass(ScriptAssignStatement.class);
  }

  @Override
  @Nullable
  public ScriptAwaitStatement getAwaitStatement() {
    return findChildByClass(ScriptAwaitStatement.class);
  }

  @Override
  @Nullable
  public ScriptClassStatement getClassStatement() {
    return findChildByClass(ScriptClassStatement.class);
  }

  @Override
  @Nullable
  public ScriptClassnameStatement getClassnameStatement() {
    return findChildByClass(ScriptClassnameStatement.class);
  }

  @Override
  @Nullable
  public ScriptConstStatement getConstStatement() {
    return findChildByClass(ScriptConstStatement.class);
  }

  @Override
  @Nullable
  public ScriptElifStatement getElifStatement() {
    return findChildByClass(ScriptElifStatement.class);
  }

  @Override
  @Nullable
  public ScriptElseStatement getElseStatement() {
    return findChildByClass(ScriptElseStatement.class);
  }

  @Override
  @Nullable
  public ScriptEnumStatement getEnumStatement() {
    return findChildByClass(ScriptEnumStatement.class);
  }

  @Override
  @Nullable
  public ScriptExpressionStatement getExpressionStatement() {
    return findChildByClass(ScriptExpressionStatement.class);
  }

  @Override
  @Nullable
  public ScriptExtendsStatement getExtendsStatement() {
    return findChildByClass(ScriptExtendsStatement.class);
  }

  @Override
  @Nullable
  public ScriptForStatement getForStatement() {
    return findChildByClass(ScriptForStatement.class);
  }

  @Override
  @Nullable
  public ScriptFuncStatement getFuncStatement() {
    return findChildByClass(ScriptFuncStatement.class);
  }

  @Override
  @Nullable
  public ScriptIconStatement getIconStatement() {
    return findChildByClass(ScriptIconStatement.class);
  }

  @Override
  @Nullable
  public ScriptIfStatement getIfStatement() {
    return findChildByClass(ScriptIfStatement.class);
  }

  @Override
  @Nullable
  public ScriptMatchLabelStatement getMatchLabelStatement() {
    return findChildByClass(ScriptMatchLabelStatement.class);
  }

  @Override
  @Nullable
  public ScriptMatchStatement getMatchStatement() {
    return findChildByClass(ScriptMatchStatement.class);
  }

  @Override
  @Nullable
  public ScriptReturnStatement getReturnStatement() {
    return findChildByClass(ScriptReturnStatement.class);
  }

  @Override
  @Nullable
  public ScriptSignalStatement getSignalStatement() {
    return findChildByClass(ScriptSignalStatement.class);
  }

  @Override
  @Nullable
  public ScriptToolStatement getToolStatement() {
    return findChildByClass(ScriptToolStatement.class);
  }

  @Override
  @Nullable
  public ScriptVarStatement getVarStatement() {
    return findChildByClass(ScriptVarStatement.class);
  }

  @Override
  @Nullable
  public ScriptWhileStatement getWhileStatement() {
    return findChildByClass(ScriptWhileStatement.class);
  }

  @Override
  @Nullable
  public ScriptYieldStatement getYieldStatement() {
    return findChildByClass(ScriptYieldStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getLineBreak() {
    return findChildByType(LINE_BREAK);
  }

}
