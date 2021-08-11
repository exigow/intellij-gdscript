// This is a generated file. Not intended for manual editing.
package tscn.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TscnFunctionExpression extends PsiElement {

  @NotNull
  List<TscnDictionaryExpression> getDictionaryExpressionList();

  @NotNull
  List<TscnExtExpression> getExtExpressionList();

  @NotNull
  List<TscnFunctionExpression> getFunctionExpressionList();

  @NotNull
  List<TscnListExpression> getListExpressionList();

  @NotNull
  List<TscnResourceString> getResourceStringList();

  @NotNull
  List<TscnSubExpression> getSubExpressionList();

  @NotNull
  PsiElement getIdentifier();

}
