package com.elyx

import org.jire.js5server.Js5Server
import java.io.File


object RunJs5 {

    private val DATA_LOCATION = File("data")
    private val CACHE_LOCATION = File(DATA_LOCATION,"cache")

    fun init() {
        println("Found cache$CACHE_LOCATION")
        val ports = arrayOf(443, 43594, 50000)
        Js5Server.init(CACHE_LOCATION.absolutePath, ports.toIntArray(), version = 217, false)
    }
}

fun main(args: Array<String>) {
    RunJs5.init()
}
