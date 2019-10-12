package script.annotator

class FunctionCallAnnotatorTest : BaseAnnotatorTest() {

    fun `test deg2rad function`() =
        assertInfo("""radians = <info descr="null">deg2rad</info>(147)""")

    fun `test cosh function`() =
        assertInfo("""x = <info descr="null">cosh</info>(0.13)""")

}