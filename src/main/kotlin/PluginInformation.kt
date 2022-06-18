import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  插件信息的json文件的映射对象
 * */
@Serializable
data class PluginInformation(
    @SerialName("class")
    val clazz: String,
    @SerialName("dependencies")
    val dependencies: List<String>,
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("version")
    val version: Int
)