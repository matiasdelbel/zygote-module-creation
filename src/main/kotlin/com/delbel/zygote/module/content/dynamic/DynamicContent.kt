package com.delbel.zygote.module.content.dynamic

import com.delbel.zygote.module.Module
import com.delbel.zygote.writer.ContentWriter

abstract class DynamicContent {

    abstract val name: String

    open fun write(writer: ContentWriter, module: Module) = writer.write(
        targetName = module.relativePathFor(file = this),
        content = module.contentFor(file = this)
    )

    abstract fun pathIn(module: Module): String

    abstract fun content(module: Module): String
}