package com.delbel.zygote.writer

import java.io.File

abstract class ContentWriter(protected val root: File) {

    abstract fun write(targetName: String, content: String)

    abstract fun copy(targetName: String, sourcePath: String)

    abstract fun clone(subPath: String): ContentWriter
}

class FileContentWriter(root: File) : ContentWriter(root) {

    override fun write(targetName: String, content: String) {
        val buildGradleFile = File(root, targetName)
        buildGradleFile.bufferedWriter().use { out -> out.write(content) }
    }

    override fun copy(targetName: String, sourcePath: String) {
        val origin = readFromResource(file = sourcePath)
        val destination = File(root, targetName)

        origin.copyTo(destination, overwrite = true)
    }

    override fun clone(subPath: String) = FileContentWriter(root = File(root, subPath))

    private fun readFromResource(file: String) = File(ContentWriter::class.java.getResource(file).toURI())
}