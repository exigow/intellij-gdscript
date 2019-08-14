package plugin.deserialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.databind.deser.std.StringDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.intellij.lang.annotations.Language
import plugin.deserialization.models.Document
import java.io.File


class DocumentDeserializer {

    fun deserializeResource(resourceName: String): Document {
        val file = File("src/main/resources-gen/docs/$resourceName")
        return deserializeFile(file)
    }

    fun deserializeText(@Language("xml") xml: String): Document {
        val fixedXml = fixTagsWithWhitespaces(xml)
        return configureMapper().readValue(fixedXml, Document::class.java)
    }

    fun deserializeFile(xml: File) = deserializeText(xml.readText())

    private fun fixTagsWithWhitespaces(content: String): String {
        // empty <constants> tag may contain newline whitespaces
        // which cause deserializer to recognize them as a VALUE_STRING
        return content.replace("<constants>\\s+</constants>".toRegex(), "<constants></constants>")
    }

    private fun configureMapper() = XmlMapper()
        .registerModule(KotlinModule())
        .registerModule(createStringNullifyModule())
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

    private fun createStringNullifyModule(): Module {
        val stringDeserializer = object : JsonDeserializer<String>() {

            override fun deserialize(p: JsonParser, ctxt: DeserializationContext): String? {
                if (isBlankString(p))
                    return null
                return StringDeserializer.instance.deserialize(p, ctxt)
            }

            private fun isBlankString(p: JsonParser) = p.currentToken == JsonToken.VALUE_STRING && p.text.isBlank()

        }
        return SimpleModule().addDeserializer(String::class.java, stringDeserializer)
    }

}
