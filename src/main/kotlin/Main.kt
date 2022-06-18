import me.edgeatzero.plugin.TestApi
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.reflect.full.primaryConstructor

fun main(args: Array<String>) {
    println(args.joinToString())
    val dir = System.getProperty("user.dir")
    val pluginPath = Paths.get(dir, "test-plugin", "build", "libs", "test-plugin.jar")
    fun1(pluginPath)
    val libraryPath = Paths.get(dir, "test-library-override", "build", "libs", "test-library-override.jar")
    val handle = MyJarClassLoader(libraryPath) { ::main.javaClass.classLoader.loadClass(it) }
    fun2(pluginPath, handle)
}

fun fun1(path: Path) {
    val loader = MyClassLoader(path) {
        ::main.javaClass.classLoader.loadClass(it)
    }
    val anyClass = loader.loadClass(loader.information.clazz).kotlin
    val any = anyClass.primaryConstructor!!.call() as TestApi
    any.testRun()
}

fun fun2(path: Path, handler: ClassLoader) {
    val loader = MyClassLoader(path) {
        handler.loadClass(it)
    }
    val anyClass = loader.loadClass(loader.information.clazz).kotlin
    val any = anyClass.primaryConstructor!!.call() as TestApi
    any.testRun()
}