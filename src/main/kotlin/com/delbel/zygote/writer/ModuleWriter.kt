package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.GitIgnore
import com.delbel.zygote.feature.module.SourceTest
import com.delbel.zygote.feature.module.ProGuard
import com.delbel.zygote.feature.module.SourceMain

abstract class ModuleWriter<T>(protected val parent: T) {

    abstract fun visit(proguard: ProGuard)

    abstract fun visit(gitIgnore: GitIgnore)

    abstract fun visit(sourceMain: SourceMain)

    abstract fun visit(sourceTest: SourceTest)
}

interface ModuleWriteable {

    fun <T> create(writer: ModuleWriter<T>)
}