package com.elyx

import org.jire.js5server.MainNew
import java.io.File


object RunJs5 {

    private val DATA_LOCATION = File("data")
    private val CACHE_LOCATION = File(DATA_LOCATION,"cache")

    fun init() {
        println("Found cache$CACHE_LOCATION")
        MainNew.init(CACHE_LOCATION)
    }
}

fun main(args: Array<String>) {
    RunJs5.init()
}
