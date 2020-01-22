package tasks

import com.google.gson.GsonBuilder
import java.io.File

fun serialize(obj: Any, location: String) {
    val writer = File(location).writer()
    GsonBuilder()
        .setPrettyPrinting()
        .create()
        .toJson(obj, writer)
    writer.flush()
}