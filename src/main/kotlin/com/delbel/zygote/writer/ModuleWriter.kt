package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.*

abstract class ModuleWriter<T>(protected val parent: T) {

    abstract fun visit(proguard: ProGuard)

    abstract fun visit(gitIgnore: GitIgnore)

    abstract fun visit(sourceMain: SourceMain)

    abstract fun visit(sourceTest: SourceTest)

    abstract fun visit(manifest: Manifest)
}

interface ModuleWriteable {

    fun <T> create(writer: ModuleWriter<T>)
}