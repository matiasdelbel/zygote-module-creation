package com.delbel.zygote.feature.content.dynamic

import com.delbel.zygote.feature.Module
import com.delbel.zygote.writer.ContentWriter

abstract class DynamicContent {

    abstract val name: String

    fun write(writer: ContentWriter, module: Module) = writer.write(
        targetName = module.relativePathFor(file = this),
        content = module.contentFor(file = this)
    )

    abstract fun pathIn(module: Module): String

    abstract fun content(module: Module): String
}