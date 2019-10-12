package script.annotator

class MethodAnnotatorTest : BaseAnnotatorTest() {

    fun `test function declaration`() =
        assertInfo("""func <info descr="null">_init</info>():""")

    fun `test static function declaration`() =
        assertInfo("""static func <info descr="null">add</info>():""")

}