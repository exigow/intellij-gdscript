package tscn

import com.intellij.ide.highlighter.custom.SyntaxTable

internal object TscnSyntaxTable {

    fun configured() = SyntaxTable()
        .also {
            it.isHasBraces = true
            it.isHasBrackets = true
            it.isHasParens = true
            it.lineComment = ";"
            it.keywords1 += listOf("true", "false")
            it.keywords3 += listOf(
                "gd_scene",
                "resource",
                "gd_resource",
                "ext_resource",
                "sub_resource",
                "node",
                "connection")
            it.keywords4 += listOf("Resource", "SubResource", "ExtResource")
        }

}
