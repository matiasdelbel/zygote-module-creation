package com.delbel.zygote.feature.content.source

import com.delbel.zygote.feature.content.dynamic.ManifestFile
import com.delbel.zygote.feature.module.Module
import com.delbel.zygote.writer.ContainerWriter
import com.delbel.zygote.writer.ContentWriter

abstract class Source {

    protected abstract val manifest: ManifestFile?

    abstract fun path(): String

    fun write(containerWriter: ContainerWriter, contentWriter: ContentWriter, module: Module) {
        createPackagesDirectory(containerWriter = containerWriter, module = module)

        writeManifestIfNeed(contentWriter = contentWriter, module = module)
        writeCustomContent(contentWriter = contentWriter)
    }

    private fun createPackagesDirectory(containerWriter: ContainerWriter, module: Module) =
        containerWriter.create(path = module.pathFor(source = this))

    private fun writeManifestIfNeed(contentWriter: ContentWriter, module: Module) =
        manifest?.write(contentWriter, module)

    protected open fun writeCustomContent(contentWriter: ContentWriter) {}
}