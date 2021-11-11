// This is a generated file. Not intended for manual editing.
package gdscript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ScriptBlock extends PsiElement {

  @NotNull
  List<ScriptAssertStatement> getAssertStatementList();

  @NotNull
  List<ScriptAssignStatement> getAssignStatementList();

  @NotNull
  List<ScriptAwaitStatement> getAwaitStatementList();

  @NotNull
  List<ScriptClassStatement> getClassStatementList();

  @NotNull
  List<ScriptClassnameStatement> getClassnameStatementList();

  @NotNull
  List<ScriptConstStatement> getConstStatementList();

  @NotNull
  List<ScriptElifStatement> getElifStatementList();

  @NotNull
  List<ScriptElseStatement> getElseStatementList();

  @NotNull
  List<ScriptEnumStatement> getEnumStatementList();

  @NotNull
  List<ScriptExpressionStatement> getExpressionStatementList();

  @NotNull
  List<ScriptExtendsStatement> getExtendsStatementList();

  @NotNull
  List<ScriptForStatement> getForStatementList();

  @NotNull
  List<ScriptFuncStatement> getFuncStatementList();

  @NotNull
  List<ScriptIconStatement> getIconStatementList();

  @NotNull
  List<ScriptIfStatement> getIfStatementList();

  @NotNull
  List<ScriptMatchLabelStatement> getMatchLabelStatementList();

  @NotNull
  List<ScriptMatchStatement> getMatchStatementList();

  @NotNull
  List<ScriptReturnStatement> getReturnStatementList();

  @NotNull
  List<ScriptSignalStatement> getSignalStatementList();

  @NotNull
  List<ScriptToolStatement> getToolStatementList();

  @NotNull
  List<ScriptVarStatement> getVarStatementList();

  @NotNull
  List<ScriptWhileStatement> getWhileStatementList();

  @NotNull
  List<ScriptYieldStatement> getYieldStatementList();

}
