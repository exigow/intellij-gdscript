package gdscript.completion.utilities

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import gdscript.completion.utilities.models.Documentation
import org.intellij.lang.annotations.Language
import java.io.File


object BuiltInClassDeserializer {

    fun deserializeResource(resourceName: String): Documentation {
        val file = File("src/main/resources/docs/$resourceName")
        return deserializeFile(file)
    }

    fun deserializeResourceResource(resourceName: String): Documentation {
        val text = BuiltInClassDeserializer::class.java.getResource(resourceName).readText()
        return deserializeText(text)
    }

    fun deserializeText(@Language("xml") xml: String): Documentation {
        val fixedXml = fixTagsWithOnlyWhitespaces(xml)
        return configureMapper().readValue(fixedXml, Documentation::class.java)
    }

    fun deserializeFile(xml: File) = deserializeText(xml.readText())

    private fun fixTagsWithOnlyWhitespaces(content: String): String {
        // empty <constants> tag may contain newline whitespaces
        // which cause deserializer to recognize them as a VALUE_STRING
        return content.replace("<constants>\\s+</constants>".toRegex(), "<constants></constants>")
    }

    private fun configureMapper() = XmlMapper()
        .registerModule(KotlinModule())
        .registerModule(StringTrimModule())
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

    private class StringTrimModule : SimpleModule() {

        init {
            val trimDeserializer = object : StdScalarDeserializer<String>(String::class.java) {

                override fun deserialize(parser: JsonParser, context: DeserializationContext)
                    = parser.valueAsString.trim()

            }
            addDeserializer(String::class.java, trimDeserializer)
        }
    }

}
