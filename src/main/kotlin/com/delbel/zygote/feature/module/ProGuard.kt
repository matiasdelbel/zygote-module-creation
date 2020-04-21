package com.delbel.zygote.feature.module

import com.delbel.zygote.writer.ModuleWriteable
import com.delbel.zygote.writer.ModuleWriter

object ProGuard : ModuleWriteable {

    override fun <T> create(writer: ModuleWriter<T>) = writer.visit(proguard = this)
}