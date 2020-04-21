package com.delbel.zygote.writer

import com.delbel.zygote.feature.Feature
import com.delbel.zygote.feature.module.Module

abstract class Writer<T>(protected val root: T) {

    abstract fun visit(feature: Feature)

    abstract fun visit(module: Module) : ModuleWriter<T>
}

interface Writeable {

    fun <T> create(writer: Writer<T>)
}