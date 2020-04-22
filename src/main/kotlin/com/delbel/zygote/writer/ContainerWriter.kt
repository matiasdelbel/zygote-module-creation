package com.delbel.zygote.writer

import java.io.File

interface ContainerWriter {

    fun create(path: String)
}

class DirectoryContainerWriter(private val root: File) : ContainerWriter {

    private val logger: ContainerWriter = LogContainerWriter(root)

    override fun create(path: String) {
        logger.create(path)

        File(root, path).mkdirs()
    }
}


class LogContainerWriter(private val root: File) : ContainerWriter {

    override fun create(path: String) {
        println("DIRECTORY: $root/$path")
    }
}