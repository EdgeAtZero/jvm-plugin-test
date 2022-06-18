package me.edgeatzero.plugin.impl

import me.edgeatzero.library.Library
import me.edgeatzero.plugin.TestApi

class ImplApi : TestApi {
    override fun testRun() {
        println("run successful(${hashCode()})")
        println(Library::class.java.classLoader)
        println("library version: " + Library().version)
    }
}