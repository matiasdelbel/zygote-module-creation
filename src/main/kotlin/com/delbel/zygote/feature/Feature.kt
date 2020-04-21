package com.delbel.zygote.feature

import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

class Feature private constructor(val name: String, private val modules: List<Module>) : Writeable {

    override fun <T> create(writer: Writer<T>) {
        writer.visit(feature = this)
        modules.forEach { it.create(writer) }
    }

    class Builder(private val name: String) {

        private val modules = mutableListOf<Module>()

        fun module(module: Module.Builder): Builder {
            module.parent(name)
            modules.add(module.build())

            return this
        }

        fun build(): Feature = Feature(name, modules)
    }
}