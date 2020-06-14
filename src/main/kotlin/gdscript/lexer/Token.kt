package gdscript.lexer

import com.intellij.psi.tree.IElementType

data class Token(
    val start: Int,
    val end: Int,
    val type: IElementType
)