import java.net.URLClassLoader
import java.nio.file.Path

open class MyJarClassLoader(
    path: Path,
    private val handler: (String) -> Class<*>
) : URLClassLoader(arrayOf(path.toUri().toURL()), null) {
    override fun findClass(name: String): Class<*> {
        return try {
            super.findClass(name)
        } catch (e: Exception) {
            handler(name)
        }
    }
}