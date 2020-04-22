package com.delbel.zygote.feature.content.hard

import com.delbel.zygote.writer.ContentWriter

abstract class HardContent {

    protected abstract val name: String
    protected abstract val source: String

    fun write(writer: ContentWriter) = writer.copy(targetName = name, sourcePath = source)
}