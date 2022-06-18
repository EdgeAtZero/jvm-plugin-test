import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Path

/**
 *  一个简单的类加载器,加载类时先向jar包查询再依赖变量 [handler] 查询类
 * */
open class MyJarClassLoader(
    path: Path,
    private val handler: (String) -> Class<*>
) : URLClassLoader(arrayOf(path.toUri().toURL()), /*parent = null 可以防止父类加载器加载资源导致资源加载错误*/null) {
    override fun findClass(name: String): Class<*> {
        return try {
            super.findClass(name)
        } catch (e: ClassNotFoundException) {
            handler(name)
        }
    }

    override fun findResource(name: String?): URL {
        return super.findResource(name)
    }
}