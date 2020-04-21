package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.GitIgnore
import com.delbel.zygote.feature.module.ProGuard

abstract class ModuleWriter<T>(protected val parent: T) {

    abstract fun visit(proguard: ProGuard)

    abstract fun visit(gitIgnore: GitIgnore)
}

interface ModuleWriteable {

    fun <T> create(writer: ModuleWriter<T>)
}