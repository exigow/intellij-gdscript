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

public class ScriptLuaDictionaryExpressionImpl extends ScriptBaseElement implements ScriptLuaDictionaryExpression {

  public ScriptLuaDictionaryExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ScriptVisitor visitor) {
    visitor.visitLuaDictionaryExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ScriptVisitor) accept((ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ScriptLuaDictionaryEntry> getLuaDictionaryEntryList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ScriptLuaDictionaryEntry.class);
  }

}