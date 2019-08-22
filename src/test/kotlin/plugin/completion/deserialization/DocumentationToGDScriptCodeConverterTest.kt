package plugin.completion.deserialization

import org.junit.Test

class DocumentationToGDScriptCodeConverterTest {

    @Test
    fun asd() {
        val document = DocumentationDeserializer.deserializeResource("Vector2.xml")
        print(DocumentationToGDScriptCodeConverter.generate(document))
    }

}