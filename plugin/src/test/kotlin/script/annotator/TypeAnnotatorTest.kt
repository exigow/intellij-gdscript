package script.annotator

class TypeAnnotatorTest : BaseAnnotatorTest() {

    fun `test Vector2 type`() =
        assertInfo("""var position: <info descr="Type">Vector2</info>""")

    fun `test String type`() =
        assertInfo("""var name: <info descr="Type">String</info>""")

    fun `test float type`() =
        assertInfo("""var number: <info descr="Type">float</info>""")

    fun `test Node type`() =
        assertInfo("""extends <info descr="Type">Node</info>""")

}