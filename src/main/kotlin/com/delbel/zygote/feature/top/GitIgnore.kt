package com.delbel.zygote.feature.top


import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

class GitIgnore(val parent: String) : Writeable {

    override fun <T> create(writer: Writer<T>) = writer.visit(gitIgnore = this)
}