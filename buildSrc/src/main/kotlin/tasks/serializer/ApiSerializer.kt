package tasks.serializer

import com.google.gson.GsonBuilder
import java.io.File

object ApiSerializer {

    fun serialize(obj: Any, location: String) {
        val writer = File(location).writer()
        GsonBuilder()
            .setPrettyPrinting()
            .registerTypeHierarchyAdapter(Boolean::class.javaObjectType, SkipFalseBooleanAdapter())
            .registerTypeHierarchyAdapter(Collection::class.java, SkipOnEmptyCollectionAdapter())
            .registerTypeHierarchyAdapter(String::class.java, SkipEmptyStringAdapter())
            .create()
            .toJson(obj, writer)
        writer.flush()
    }

}



