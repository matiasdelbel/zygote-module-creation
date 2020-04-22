package com.delbel.zygote.writer

import java.io.File

interface ContainerWriter {

    fun create(path: String)
}

class DirectoryContainerWriter(private val root: File) : ContainerWriter {

    override fun create(path: String) {
        File(root, path).mkdirs()
    }
}