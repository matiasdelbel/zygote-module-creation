package com.delbel.zygote.writer

import java.io.File

abstract class ContainerWriter(protected val root: File) {

    abstract fun create(path: String)

    abstract fun clone(subPath: String): ContainerWriter
}

class DirectoryContainerWriter(root: File) : ContainerWriter(root) {

    override fun create(path: String) {
        File(root, path).mkdirs()
    }

    override fun clone(subPath: String) = DirectoryContainerWriter(root = File(root, subPath))
}