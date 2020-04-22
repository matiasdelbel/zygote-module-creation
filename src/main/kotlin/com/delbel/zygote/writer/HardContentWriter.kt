package com.delbel.zygote.writer

import java.io.File

interface HardContentWriter {

    fun copy(sourcePath: String, targetName: String)
}

class FileHardContentWriter(private val module: File) : HardContentWriter {

    override fun copy(sourcePath: String, targetName: String) {
        val origin = readFromResource(file = sourcePath)
        val destination = File(module, targetName)

        origin.copyTo(destination, overwrite = true)
    }

    private fun readFromResource(file: String) = File(ModuleWriter::class.java.getResource(file).toURI())
}