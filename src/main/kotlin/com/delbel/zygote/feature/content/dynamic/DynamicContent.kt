package com.delbel.zygote.feature.content.dynamic

import com.delbel.zygote.feature.module.Module
import com.delbel.zygote.writer.ContentWriter

abstract class DynamicContent {

    protected abstract val name: String

    fun write(writer: ContentWriter, module: Module) = writer.write(targetName = name, content = module.visit(this))

    abstract fun accept(module: Module): String
}