package gdscript.completion.utilities

import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.util.PsiTreeUtil

object PsiElementUtil {

    fun PsiElement.prevLeaf() =
        PsiTreeUtil.prevLeaf(this) as? LeafPsiElement

}