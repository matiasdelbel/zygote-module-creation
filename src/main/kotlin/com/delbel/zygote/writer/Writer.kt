package com.delbel.zygote.writer

import com.delbel.zygote.feature.Feature
import com.delbel.zygote.feature.Module
import com.delbel.zygote.feature.top.GitIgnore
import com.delbel.zygote.feature.top.ProGuard

abstract class Writer<T>(protected val root: T) {

    abstract fun visit(feature: Feature)

    abstract fun visit(module: Module)

    abstract fun visit(proguard: ProGuard)

    abstract fun visit(gitIgnore: GitIgnore)
}

interface Writeable {

    fun <T> create(writer: Writer<T>)
}