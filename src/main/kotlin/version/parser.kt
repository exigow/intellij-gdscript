package version

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import version.data.*

fun parseClass(doc: Document) = Class(
    name = doc.select("class").attr("name"),
    extends = doc.select("class").attr("inherits"),
    fields = doc.select("member").map { parseField(it) },
    methods = doc.select("method").map { parseMethod(it) },
    constants = doc.select("constant").map { parseConstant(it) }
)

private fun parseField(field: Element) = Field(
    name = field.attr("name"),
    type = field.attr("type"),
    setter = field.attr("setter"),
    getter = field.attr("getter"),
    default = field.attr("default")
)

private fun parseMethod(method: Element) = Method(
    name = method.attr("name"),
    type = method.select("return").attr("type"),
    arguments = parseArguments(method),
    vararg = method.attr("qualifiers") == "vararg"
)

private fun parseConstant(constant: Element) = Constant(
    name = constant.attr("name"),
    value = constant.attr("value")
)

private fun parseArguments(method: Element) = method.select("argument")
    .sortedBy { it.attr("index") }
    .map { Argument(it.attr("name"), it.attr("type")) }