package gdscript.completion.utilities

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import gdscript.completion.utilities.models.Class
import org.intellij.lang.annotations.Language


object ClassDeserializer {

    fun deserializeResource(resourceName: String): Class {
        val text = this::class.java.getResource(resourceName).readText()
        return deserializeText(text)
    }

    fun deserializeText(@Language("xml") xml: String): Class {
        val fixedXml: String = fixTagsWithOnlyWhitespaces(xml)
        return configureMapper().readValue(fixedXml, Class::class.java)
    }

    private fun fixTagsWithOnlyWhitespaces(content: String) =
        content.replace("<constants>\\s+</constants>".toRegex(), "<constants></constants>")

    private fun configureMapper() = XmlMapper()
        .registerModule(KotlinModule())
        .registerModule(StringTrimModule())
        .disable(FAIL_ON_UNKNOWN_PROPERTIES)

    private class StringTrimModule : SimpleModule() {

        init {
            addDeserializer(String::class.java, StringDeserializer())
        }

    }

    private class StringDeserializer : StdScalarDeserializer<String>(String::class.java) {

        override fun deserialize(parser: JsonParser, context: DeserializationContext)
            = parser.valueAsString.trim()

    }

}
