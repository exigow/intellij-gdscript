package script.annotator

class TypeAnnotatorTest : BaseAnnotatorTest() {

    fun `test Vector2 type`() =
        assertInfo("""var position: <info descr="null">Vector2</info>""")

    fun `test String type`() =
        assertInfo("""var name: <info descr="null">String</info>""")

    fun `test float type`() =
        assertInfo("""var number: <info descr="null">float</info>""")

    fun `test Node type`() =
        assertInfo("""extends <info descr="null">Node</info>""")

}