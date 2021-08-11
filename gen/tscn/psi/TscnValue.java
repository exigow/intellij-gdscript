// This is a generated file. Not intended for manual editing.
package tscn.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TscnValue extends PsiElement {

  @Nullable
  TscnDictionaryExpression getDictionaryExpression();

  @Nullable
  TscnExtExpression getExtExpression();

  @Nullable
  TscnFunctionExpression getFunctionExpression();

  @Nullable
  TscnListExpression getListExpression();

  @Nullable
  TscnResourceString getResourceString();

  @Nullable
  TscnSubExpression getSubExpression();

  @Nullable
  PsiElement getDoubleQuotedString();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getSingleQuotedString();

}
