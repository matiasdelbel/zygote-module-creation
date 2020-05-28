package com.delbel.zygote.writer

class StringContainerWriter(private val root: String, private val buffer: StringBuffer) : ContainerWriter {

    override fun create(path: String) {
        buffer.appendln("DIRECTORY: $root/$path")
    }
}