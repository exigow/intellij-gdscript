package plugin.completion.deserialization

import org.junit.Test

class DocumentationToCodeConverterTest {

    @Test
    fun asd() {
        val document = DocumentationDeserializer.deserializeResource("Vector2.xml")
        print(DocumentationToCodeConverter.generate(document))
    }

}