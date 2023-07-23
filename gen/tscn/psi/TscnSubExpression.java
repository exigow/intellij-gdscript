// This is a generated file. Not intended for manual editing.
package tscn.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TscnSubExpression extends PsiElement {

  @Nullable
  PsiElement getDoubleQuotedString();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getSingleQuotedString();

  @NotNull
  PsiReference getReference();

}
