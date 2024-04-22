package com.elyx

import com.elyx.custom.PackSprites
import dev.openrune.cache.tools.tasks.CacheTask
import java.io.File


val REV : Int = 221
val DATA_LOCATION = File("./data")
val CACHE_LOCATION = File(DATA_LOCATION,"cache")
val XTEAS = File(DATA_LOCATION,"cache/xteas.json")
val RAW_CACHE_LOCATION = File(DATA_LOCATION,"raw-cache")

fun getCustomDir(loc : String): File {
    return File(RAW_CACHE_LOCATION,loc)
}

val tasks : Array<CacheTask> = arrayOf(
    PackSprites(getCustomDir("sprites"))
)