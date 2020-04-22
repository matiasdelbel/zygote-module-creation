package com.delbel.zygote.feature

import com.delbel.zygote.feature.module.Module
import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

class Feature(private val modules: List<Module> = emptyList()) : Writeable {

    override fun <T> create(writer: Writer<T>) {
        writer.visit(feature = this)
        modules.forEach { it.create(writer) }
    }
}