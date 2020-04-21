package com.delbel.zygote.feature.top

import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

class ProGuard(val parent: String) : Writeable {

    override fun <T> create(writer: Writer<T>) = writer.visit(proguard = this)
}