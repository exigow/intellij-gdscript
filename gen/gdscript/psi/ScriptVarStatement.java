// This is a generated file. Not intended for manual editing.
package gdscript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ScriptVarStatement extends PsiElement {

  @Nullable
  ScriptExpression getExpression();

  @NotNull
  ScriptId getId();

  @Nullable
  ScriptType getType();

  @Nullable
  ScriptVarExport getVarExport();

  @Nullable
  ScriptVarGetter getVarGetter();

  @Nullable
  ScriptVarSetter getVarSetter();

}
