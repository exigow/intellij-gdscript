package plugin.completion.deserialization

import org.junit.Test

class CodeGeneratorTest {

    @Test
    fun asd() {
        val document = DocumentDeserializer.deserializeResource("Vector2.xml")
        print(CodeGenerator.generate(document))
    }

}