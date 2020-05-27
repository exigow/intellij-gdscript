package tscn

import com.intellij.ide.highlighter.custom.SyntaxTable

internal class TscnSyntaxTable : SyntaxTable() {

    init {
        isHasBraces = true
        isHasBrackets = true
        isHasParens = true
        lineComment = ";"
        keywords1 += listOf("true", "false")
        keywords3 += listOf("gd_scene", "ext_resource", "sub_resource", "node", "connection")
        keywords4 += listOf("Resource", "SubResource", "ExtResource")
    }

}
