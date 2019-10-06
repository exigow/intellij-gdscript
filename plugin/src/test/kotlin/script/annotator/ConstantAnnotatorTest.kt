package script.annotator

class ConstantAnnotatorTest : BaseAnnotatorTest() {

    fun `test NUMBER constant`() =
        assertInfo("""const <info descr="null">NUMBER</info> = 100""")

    fun `test SOME_VALUE constant`() =
        assertInfo("""const <info descr="null">SOME_VALUE</info> = 0""")

    fun `test PI language-level constant`() =
        assertInfo("""rad = <info descr="null">PI</info>""")

}