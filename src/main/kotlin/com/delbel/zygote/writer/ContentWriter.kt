package com.delbel.zygote.writer

import java.io.File

interface ContentWriter {

    fun write(targetName: String, content: String)

    fun copy(targetName: String, sourcePath: String)
}

class FileContentWriter(private val root: File) : ContentWriter {

    override fun write(targetName: String, content: String) {
        val buildGradleFile = File(root, targetName)
        buildGradleFile.bufferedWriter().use { out -> out.write(content) }
    }

    override fun copy(targetName: String, sourcePath: String) {
        val origin = readFromResource(file = sourcePath)
        val destination = File(root, targetName)

        origin.copyTo(destination, overwrite = true)
    }

    private fun readFromResource(file: String) = File(ContentWriter::class.java.getResource(file).toURI())
}