package com.delbel.zygote.feature.content.dynamic

import com.delbel.zygote.writer.ContentWriter

abstract class DynamicContent {

    protected abstract val name: String
    protected abstract val source: String

    fun write(writer: ContentWriter, context: ContentContext) =
        writer.write(targetName = name, content = context.visit(this))

    abstract fun accept(context: ContentContext): String
}