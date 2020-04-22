package com.delbel.zygote.writer

import java.io.File

interface ContainerWriter {

    fun create(path: String)
}

class DirectoryContainerWriter(private val module: File) : ContainerWriter {

    override fun create(path: String) {
        File(module, path).mkdirs()
    }
}