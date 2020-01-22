package tasks

import com.google.gson.*
import java.io.File
import java.lang.reflect.Type

fun serialize(obj: Any, location: String) {
    val writer = File(location).writer()
    GsonBuilder()
        .setPrettyPrinting()
        .registerTypeHierarchyAdapter(Collection::class.java, SkipOnEmptyCollectionAdapter())
        .create()
        .toJson(obj, writer)
    writer.flush()
}

private class SkipOnEmptyCollectionAdapter : JsonSerializer<List<*>?> {

    override fun serialize(src: List<*>?, typeOfSrc: Type?, context: JsonSerializationContext): JsonElement? {
        if (src == null || src.isEmpty())
            return null
        return serializeCollection(src, context)
    }

    private fun serializeCollection(src: List<*>, context: JsonSerializationContext) =
        JsonArray().apply {
            src.map { context.serialize(it) }.forEach { add(it) }
        }

}