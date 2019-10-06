package script.annotator

class ConstantAnnotatorTest : BaseAnnotatorTest() {

    fun `test constant`() = assertInfo("""const <info descr="null">NUMBER</info> = 100""")

}