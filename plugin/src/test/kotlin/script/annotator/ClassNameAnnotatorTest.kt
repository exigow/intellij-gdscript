package script.annotator

class ClassNameAnnotatorTest : BaseAnnotatorTest() {

    fun `test variable Vector2 type`() =
        assertInfo("""var position: <info descr="null">Vector2</info>""")

    fun `test variable String type`() =
        assertInfo("""var name: <info descr="null">String</info>""")

    fun `test variable float type`() =
        assertInfo("""var number: float""")

    fun `test extends Node type`() =
        assertInfo("""extends <info descr="null">Node</info>""")

}