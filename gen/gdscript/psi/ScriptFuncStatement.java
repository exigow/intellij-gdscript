// This is a generated file. Not intended for manual editing.
package gdscript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ScriptFuncStatement extends PsiElement {

  @Nullable
  ScriptBlock getBlock();

  @NotNull
  List<ScriptFuncArgument> getFuncArgumentList();

  @NotNull
  ScriptId getId();

  @Nullable
  ScriptType getType();

}
