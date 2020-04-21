package com.delbel.zygote.feature

import com.delbel.zygote.feature.top.GitIgnore
import com.delbel.zygote.feature.top.ProGuard
import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

class Module(
    val parent: String,
    val name: String,
    private val proGuard: ProGuard? = null,
    private val gitIgnore: GitIgnore? = null
) : Writeable {

    override fun <T> create(writer: Writer<T>) {
        writer.visit(module = this)
        proGuard?.create(writer)
        gitIgnore?.create(writer)
    }
}