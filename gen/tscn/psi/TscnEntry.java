// This is a generated file. Not intended for manual editing.
package tscn.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TscnEntry extends PsiElement {

  @NotNull
  List<TscnAttribute> getAttributeList();

  @NotNull
  List<TscnProperty> getPropertyList();

  @Nullable
  PsiElement getIdentifier();

}
