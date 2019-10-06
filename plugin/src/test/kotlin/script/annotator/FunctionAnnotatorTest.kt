package script.annotator

class FunctionAnnotatorTest : BaseAnnotatorTest() {

    fun `test function declaration`() =
        assertInfo("""func <info descr="Function">_init</info>():""")

    fun `test static function declaration`() =
        assertInfo("""static func <info descr="Function">add</info>():""")

}