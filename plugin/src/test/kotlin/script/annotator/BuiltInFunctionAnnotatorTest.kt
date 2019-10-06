package script.annotator

class BuiltInFunctionAnnotatorTest : BaseAnnotatorTest() {

    fun `test deg2rad function`() =
        assertInfo("""radians = <info descr="Built-in function">deg2rad</info>(147)""")

    fun `test cosh function`() =
        assertInfo("""x = <info descr="Built-in function">cosh</info>(0.13)""")

}