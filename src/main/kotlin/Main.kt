import me.edgeatzero.plugin.TestApi
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.reflect.full.primaryConstructor

/**
 *  该应用的类加载器
 * */
val appClassLoader: ClassLoader by lazy { ::main.javaClass.classLoader }

/**
 *  主入口
 * */
fun main() {
    val pluginPath = getJarPath("test-plugin")
    fun1(pluginPath)
    val handle = MyJarClassLoader(getJarPath("test-dependence-override")) { ::main.javaClass.classLoader.loadClass(it) }
    fun2(pluginPath, handle)
}

/**
 *  普通加载
 * */
fun fun1(path: Path) {
    val loader = PluginClassLoader(path) { appClassLoader.loadClass(it) }
    val anyClass = loader.loadClass(loader.information.clazz).kotlin
    val any = anyClass.primaryConstructor!!.call() as TestApi
    any.testRun()
}

/**
 *  依赖替换
 * */
fun fun2(path: Path, handler: ClassLoader) {
    val loader = PluginClassLoader(path) { handler.loadClass(it) }
    val anyClass = loader.loadClass(loader.information.clazz).kotlin
    val any = anyClass.primaryConstructor!!.call() as TestApi
    any.testRun()
}

/**
 *  @return  返回构建后的Jar包的Path
 * */
fun getJarPath(module: String): Path = Paths.get(System.getProperty("user.dir"), module, "build", "libs", "$module.jar")