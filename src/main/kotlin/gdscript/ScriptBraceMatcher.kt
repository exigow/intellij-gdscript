package gdscript

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import gdscript.ScriptTokenSet.BRACES
import gdscript.ScriptTokenSet.BRACKETS
import gdscript.ScriptTokenSet.PARENTHESES

class ScriptBraceMatcher : PairedBraceMatcher {

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int) = openingBraceOffset

    override fun getPairs() = arrayOf(BRACES, PARENTHESES, BRACKETS)
        .map { BracePair(it.types[0], it.types[1], true) }
        .toTypedArray()

    override fun isPairedBracesAllowedBeforeType(leftBrace: IElementType, contextType: IElementType?) = true

}
