package com.elyx

import dev.openrune.cache.tools.Builder
import dev.openrune.cache.tools.tasks.TaskType

object BuildCache {
    fun init() {
        val builder = Builder(type = TaskType.BUILD, revision = REV, CACHE_LOCATION)
        builder.extraTasks(*tasks).build().initialize()
    }

}

fun main(args: Array<String>) {
    BuildCache.init()
}
