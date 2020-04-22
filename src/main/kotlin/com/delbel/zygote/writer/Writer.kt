package com.delbel.zygote.writer

import com.delbel.zygote.feature.Feature
import com.delbel.zygote.feature.module.Module

abstract class Writer<T>(
    protected val featureName: String,
    protected val packageName: String,
    protected val root: T
) {

    abstract fun visit(feature: Feature)

    abstract fun visit(module: Module): Pair<ModuleWriter<T>, HardContentWriter>
}

interface Writeable {

    fun <T> create(writer: Writer<T>)
}