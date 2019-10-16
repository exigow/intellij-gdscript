package gdscript.commenter

class ScriptCommenter : NullCommenter() {

    // todo resource commenter
    override fun getLineCommentPrefix() = "#"

    override fun getBlockCommentPrefix() = MULTILINE_STRING_MARKER

    override fun getBlockCommentSuffix() = MULTILINE_STRING_MARKER

    companion object {
        const val MULTILINE_STRING_MARKER = "\"\"\""
    }

}