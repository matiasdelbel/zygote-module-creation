package com.delbel.zygote.feature

import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

class Module private constructor(val parent: String, val name: String) : Writeable {

    override fun <T> create(writer: Writer<T>) = writer.visit(module = this)

    class Builder(private val name: String) {

        private var parent: String = ""

        fun parent(name: String): Builder {
            parent = name
            return this
        }

        fun build() = Module(parent, name)
    }
}