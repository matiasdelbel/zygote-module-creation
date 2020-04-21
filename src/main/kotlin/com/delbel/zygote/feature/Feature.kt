package com.delbel.zygote.feature

import com.delbel.zygote.writer.Writer

class Feature private constructor(private val name: String) {

    fun <T> create(writer: Writer<T>): T {
        writer.addContainer(name)

        return writer.create()
    }

    class Builder {

        private var root: String = ""

        fun root(name: String): Builder {
            root = name
            return this
        }

        fun build(): Feature = Feature(root)
    }
}