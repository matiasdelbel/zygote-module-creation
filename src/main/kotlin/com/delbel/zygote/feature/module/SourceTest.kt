package com.delbel.zygote.feature.module

import com.delbel.zygote.writer.ModuleWriteable
import com.delbel.zygote.writer.ModuleWriter

object SourceTest : ModuleWriteable {

    override fun <T> create(writer: ModuleWriter<T>) = writer.visit(sourceTest = this)

    fun resourcesPath() = "test/resources"
}