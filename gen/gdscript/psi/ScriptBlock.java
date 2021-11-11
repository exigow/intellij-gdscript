// This is a generated file. Not intended for manual editing.
package gdscript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ScriptBlock extends PsiElement {

  @Nullable
  ScriptAssertStatement getAssertStatement();

  @Nullable
  ScriptAssignStatement getAssignStatement();

  @Nullable
  ScriptAwaitStatement getAwaitStatement();

  @Nullable
  ScriptClassStatement getClassStatement();

  @Nullable
  ScriptClassnameStatement getClassnameStatement();

  @Nullable
  ScriptConstStatement getConstStatement();

  @Nullable
  ScriptElifStatement getElifStatement();

  @Nullable
  ScriptElseStatement getElseStatement();

  @Nullable
  ScriptEnumStatement getEnumStatement();

  @Nullable
  ScriptExpressionStatement getExpressionStatement();

  @Nullable
  ScriptExtendsStatement getExtendsStatement();

  @Nullable
  ScriptForStatement getForStatement();

  @Nullable
  ScriptFuncStatement getFuncStatement();

  @Nullable
  ScriptIconStatement getIconStatement();

  @Nullable
  ScriptIfStatement getIfStatement();

  @Nullable
  ScriptMatchLabelStatement getMatchLabelStatement();

  @Nullable
  ScriptMatchStatement getMatchStatement();

  @Nullable
  ScriptReturnStatement getReturnStatement();

  @Nullable
  ScriptSignalStatement getSignalStatement();

  @Nullable
  ScriptToolStatement getToolStatement();

  @Nullable
  ScriptVarStatement getVarStatement();

  @Nullable
  ScriptWhileStatement getWhileStatement();

  @Nullable
  ScriptYieldStatement getYieldStatement();

  @Nullable
  PsiElement getLineBreak();

}
