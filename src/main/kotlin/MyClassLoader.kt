import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.InputStream
import java.nio.file.Path
import java.util.*

class MyClassLoader(
    path: Path,
    handler: (String) -> Class<*>
) : MyJarClassLoader(path, handler) {
    val properties: Properties
        get() {
            val result = Properties()
            getResourceAsStream("plugin.properties")?.bufferedReader()?.let { result.load(it) }
            return result
        }

    @OptIn(ExperimentalSerializationApi::class)
    val information: PluginInformation
        get() {
            return Json.Default.decodeFromStream(getResourceAsStream("plugin.json") as InputStream)
        }
}