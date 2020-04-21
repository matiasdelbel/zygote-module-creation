package com.delbel.zygote.writer

import com.delbel.zygote.feature.Feature
import com.delbel.zygote.feature.Module

abstract class Writer<T>(protected val root: T) {

    abstract fun visit(feature: Feature)

    abstract fun visit(module: Module) : ModuleWriter<T>
}

interface Writeable {

    fun <T> create(writer: Writer<T>)
}