package tasks.serializer

import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

class SkipEmptyStringAdapter : JsonSerializer<String?> {

    override fun serialize(src: String?, typeOfSrc: Type?, context: JsonSerializationContext?) =
        if (src == null || src.isEmpty())
            null
        else
            JsonPrimitive(src)

}
