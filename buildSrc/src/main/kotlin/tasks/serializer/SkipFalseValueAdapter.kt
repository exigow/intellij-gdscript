package tasks.serializer

import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

class SkipFalseValueAdapter : JsonSerializer<Boolean?> {

    override fun serialize(src: Boolean?, typeOfSrc: Type?, context: JsonSerializationContext?) =
        if (src == null || src == false)
            null
        else
            JsonPrimitive(true)

}
