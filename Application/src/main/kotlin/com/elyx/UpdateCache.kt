package com.elyx

import dev.openrune.cache.tools.Builder
import dev.openrune.cache.tools.tasks.TaskType
import dev.openrune.cache.tools.tasks.impl.RemoveXteas

object UpdateCache {
    fun init() {
        val builder = Builder(type = TaskType.FRESH_INSTALL, revision = REV, CACHE_LOCATION)
        builder.extraTasks(*tasks,RemoveXteas(XTEAS)).build().initialize()
    }
}

fun main(args: Array<String>) {
    UpdateCache.init()
}
