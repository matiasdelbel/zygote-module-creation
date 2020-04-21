package com.delbel.zygote.feature.module

import com.delbel.zygote.writer.ModuleWriteable
import com.delbel.zygote.writer.ModuleWriter

object GitIgnore : ModuleWriteable {

    override fun <T> create(writer: ModuleWriter<T>) = writer.visit(gitIgnore = this)
}