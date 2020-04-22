package com.delbel.zygote.module.content.hard

import com.delbel.zygote.module.Module
import com.delbel.zygote.writer.ContentWriter

abstract class HardContent {

    abstract val name: String

    protected abstract val source: String

    fun write(writer: ContentWriter, module: Module) = writer.copy(targetName = module.relativePathFor(file = this), sourcePath = source)

    abstract fun pathIn(module: Module): String
}