// This is a generated file. Not intended for manual editing.
package tscn.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TscnValue extends PsiElement {

  @NotNull
  List<TscnExtResourceFunction> getExtResourceFunctionList();

  @NotNull
  List<TscnResourceString> getResourceStringList();

  @NotNull
  List<TscnSubResourceFunction> getSubResourceFunctionList();

}
