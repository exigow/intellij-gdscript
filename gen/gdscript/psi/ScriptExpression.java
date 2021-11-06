// This is a generated file. Not intended for manual editing.
package gdscript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ScriptExpression extends PsiElement {

  @NotNull
  List<ScriptArrayExpression> getArrayExpressionList();

  @NotNull
  List<ScriptDictionaryExpression> getDictionaryExpressionList();

  @NotNull
  List<ScriptId> getIdList();

  @NotNull
  List<ScriptInvocationExpression> getInvocationExpressionList();

  @NotNull
  List<ScriptLambdaExpression> getLambdaExpressionList();

  @NotNull
  List<ScriptLuaDictionaryExpression> getLuaDictionaryExpressionList();

  @NotNull
  List<ScriptString> getStringList();

}
