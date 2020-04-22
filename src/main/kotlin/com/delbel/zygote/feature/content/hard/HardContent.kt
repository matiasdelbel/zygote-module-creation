package com.delbel.zygote.feature.content.hard

import com.delbel.zygote.writer.HardContentWriter

abstract class HardContent {

    protected abstract val name: String
    protected abstract val source: String

    fun write(writer: HardContentWriter) = writer.copy(sourcePath = source, targetName = name)
}