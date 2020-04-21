package com.delbel.zygote.feature.module.files

import com.delbel.zygote.writer.ModuleWriteable
import com.delbel.zygote.writer.ModuleWriter

class ProGuard(val name: String = "proguard-rules.pro") : ModuleWriteable {

    override fun <T> create(writer: ModuleWriter<T>) = writer.visit(proguard = this)
}