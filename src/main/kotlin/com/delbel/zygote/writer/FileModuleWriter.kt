package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.Module
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest
import java.io.File

class FileModuleWriter(
    moduleFolder: File,
    packageName: String,
    private val module: Module,
    private val contentWriter: FileContentWriter
) : ModuleWriter<File>(moduleFolder, packageName) {

    override fun visit(sourceMain: SourceMain) {
        // Source
        var folder = File(moduleContainer, sourceMain.sourcePath()).also { file -> file.mkdirs() }
        val packagesSplit = packageName.split(".")
        packagesSplit.forEach { folder = File(folder, it).also { file -> file.mkdir() } }

        // TODO Manifest
        sourceMain.manifest.write(contentWriter, module = module)
    }

    override fun visit(sourceTest: SourceTest) {
        // Source
        var folder = File(moduleContainer, sourceTest.sourcePath()).also { file -> file.mkdirs() }
        val packagesSplit = packageName.split(".")
        packagesSplit.forEach { folder = File(folder, it).also { file -> file.mkdir() } } // TODO falta el feature name y layer

        // Mock marker
        sourceTest.mockMarkerFile.write(contentWriter)
    }
}