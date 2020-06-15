package tasks.serializer

import com.google.gson.JsonArray
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

class SkipOnEmptyCollectionAdapter : JsonSerializer<Collection<*>?> {

    override fun serialize(src: Collection<*>?, typeOfSrc: Type?, context: JsonSerializationContext) =
        if (src == null || src.isEmpty())
            null
        else
            JsonArray().apply { src.map { context.serialize(it) }.forEach { add(it) } }

}
