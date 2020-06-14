package gdscript.lexer.scanner

import com.intellij.psi.tree.IElementType
import gdscript.lexer.Token
import kotlin.math.min

class TrieScanner(
    words: Set<String>,
    private val type: IElementType
) : TokenScanner {

    private val trieRoot = Node()

    init {
        for (word in words) {
            var currentNode = trieRoot
            for (char in word) {
                if (currentNode.children[char] == null) {
                    currentNode.children[char] = Node()
                }
                currentNode = currentNode.children[char]!!
            }
            currentNode.word = word
        }
    }

    override fun scanToken(chars: CharSequence, start: Int): Token? {
        var current = start
        var node = trieRoot
        do {
            val char = chars[min(current, chars.length - 1)]
            val nextNode = node.children[char]
                ?: break
            node = nextNode
            current += 1
        } while (current <= chars.length)
        if (node.word != null) {
            return Token(start, current, type)
        }
        return null
    }

    private data class Node(
        var word: String? = null,
        val children: MutableMap<Char, Node> = mutableMapOf()
    )

}
