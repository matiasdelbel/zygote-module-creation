package com.delbel.zygote.feature.content.source

import com.delbel.zygote.feature.content.dynamic.ManifestFile
import com.delbel.zygote.feature.Module
import com.delbel.zygote.writer.ContainerWriter
import com.delbel.zygote.writer.ContentWriter

abstract class Source {

    protected abstract val manifest: ManifestFile?

    abstract fun src(): String

    abstract fun resources(): String

    fun write(containerWriter: ContainerWriter, contentWriter: ContentWriter, module: Module) {
        createPackagesDirectory(containerWriter = containerWriter, module = module)

        writeManifestIfNeed(contentWriter = contentWriter, module = module)
        writeCustomContent(contentWriter = contentWriter, module = module)
    }

    private fun createPackagesDirectory(containerWriter: ContainerWriter, module: Module) =
        containerWriter.create(path = module.relativePathFor(source = this))

    private fun writeManifestIfNeed(contentWriter: ContentWriter, module: Module) =
        manifest?.write(contentWriter, module)

    protected open fun writeCustomContent(contentWriter: ContentWriter, module: Module) {}
}