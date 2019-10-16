package gdscript.typing

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import gdscript.token.ScriptTokenSet.BRACES
import gdscript.token.ScriptTokenSet.BRACKETS
import gdscript.token.ScriptTokenSet.PARENTHESES

class ScriptBraceMatcher : PairedBraceMatcher {

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int) = openingBraceOffset

    override fun getPairs() = arrayOf(BRACES, PARENTHESES, BRACKETS)
        .map { BracePair(it.types[0], it.types[1], true) }
        .toTypedArray()

    override fun isPairedBracesAllowedBeforeType(leftBrace: IElementType, contextType: IElementType?) = true

}
