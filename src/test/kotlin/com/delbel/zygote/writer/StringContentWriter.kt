package com.delbel.zygote.writer

class StringContentWriter(private val root: String, private val buffer: StringBuffer) : ContentWriter {

    override fun write(targetName: String, content: String) {
        buffer.appendln(" NEW file: $root/$targetName (dynamic content)")
    }

    override fun copy(targetName: String, sourcePath: String) {
        buffer.appendln(" NEW file: $root/$targetName (source: $sourcePath)")
    }

    override fun append(targetName: String, content: String) {
        buffer.appendln("APPENDED: $root/$targetName")
    }
}