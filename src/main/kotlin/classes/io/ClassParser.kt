package classes.io

import classes.model.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import java.io.InputStream

internal object ClassParser {

    fun parseXml(input: InputStream): Class {
        val document = Jsoup.parse(input, null, "")
        return parseClass(document)
    }

    private fun parseClass(file: Element) =
        Class(
            name = file.select("class").attr("name"),
            extends = file.select("class").attr("inherits"),
            fields = file.select("member").map { parseField(it) },
            methods = file.select("method").map { parseMethod(it) },
            constants = file.select("constant").map { parseConstant(it) }
        )

    private fun parseField(field: Element) =
        Field(
            name = field.attr("name"),
            type = field.attr("type"),
            setter = field.attr("setter"),
            getter = field.attr("getter"),
            default = field.attr("default")
        )

    private fun parseMethod(method: Element) =
        Method(
            name = method.attr("name"),
            type = method.select("return").attr("type"),
            arguments = parseArguments(method),
            vararg = method.attr("qualifiers") == "vararg"
        )

    private fun parseConstant(constant: Element) =
        Constant(
            name = constant.attr("name"),
            value = constant.attr("value")
        )

    private fun parseArguments(method: Element) =
        method.select("argument")
            .sortedBy { it.attr("index") }
            .map { Argument(it.attr("name"), it.attr("type")) }

}