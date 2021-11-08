// This is a generated file. Not intended for manual editing.
package gdscript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static gdscript.psi.ScriptElementTypes.*;
import gdscript.psi.ScriptBaseElement;
import gdscript.psi.*;

public class ScriptEnumStatementImpl extends ScriptBaseElement implements ScriptEnumStatement {

  public ScriptEnumStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ScriptVisitor visitor) {
    visitor.visitEnumStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ScriptVisitor) accept((ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ScriptEnumEntry> getEnumEntryList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptEnumEntry.class);
  }

  @Override
  @Nullable
  public ScriptId getId() {
    return findChildByClass(ScriptId.class);
  }

}
