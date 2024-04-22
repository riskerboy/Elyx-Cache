package org.jire.js5server

import org.jire.js5server.codec.js5.Js5Handler
import java.io.File
import java.io.FileInputStream
import java.nio.file.Path
import java.util.*

object MainNew {

    fun init(cache : File) {
        val props = Properties().apply {
            FileInputStream("js5server.properties").use {
                load(it)
            }
        }
        props.set("cache_path",cache.absolutePath)
        val config = Js5ServiceConfig(props)

        val groupRepository =
            (Class.forName(config.groupRepository).getDeclaredConstructor().newInstance() as Js5GroupRepository).apply {
                load(Path.of(config.cachePath))
            }

        val service = Js5Service(config, groupRepository)

        for (port in config.listenPorts) {
            service.listen(port)
        }

        if (config.supportPrefetch) {
            Js5Handler.startPrefetching()
        }
    }

}