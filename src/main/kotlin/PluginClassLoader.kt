import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.InputStream
import java.nio.file.Path

/**
 *  一个简单插件的类加载器
 * */
class PluginClassLoader(
    path: Path,
    handler: (String) -> Class<*>
) : MyJarClassLoader(path, handler) {
    /**
     *  获取jar包内的插件信息
     * */
    @OptIn(ExperimentalSerializationApi::class)
    val info: PluginInformation by lazy {
        Json.Default.decodeFromStream(getResourceAsStream("plugin.json") as InputStream)
    }
}