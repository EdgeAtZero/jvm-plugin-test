package me.edgeatzero.plugin.impl

import me.edgeatzero.library.Dependence
import me.edgeatzero.plugin.TestEntrance
import java.util.Locale

/**
 *  插件
 * */
class ImplEntrance : TestEntrance {
    override fun testRun() {
        if (Locale.getDefault().country == Locale.CHINA.country) {
            println("运行成功 实例hash值 ${hashCode()}")
            println("依赖对应的类加载器 ${Dependence::class.java.classLoader}")
            println("依赖版本 " + Dependence().version)
        } else {
            println("run successfully, instance hash ${hashCode()}")
            println("dependence's ClassLoader ${Dependence::class.java.classLoader}")
            println("dependence's version " + Dependence().version)
        }
    }
}