package com.delbel.zygote.writer

import com.delbel.zygote.feature.content.dynamic.ContentContext
import com.delbel.zygote.feature.module.gradle.GatewayBuildGradle
import com.delbel.zygote.feature.module.gradle.PresentationBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest
import java.io.File

class FileModuleWriter(
    moduleFolder: File,
    packageName: String,
    private val contentWriter: FileContentWriter
) : ModuleWriter<File>(moduleFolder, packageName) {

    override fun visit(sourceMain: SourceMain) {
        // Source
        var folder = File(moduleContainer, sourceMain.sourcePath()).also { file -> file.mkdirs() }
        val packagesSplit = packageName.split(".")
        packagesSplit.forEach { folder = File(folder, it).also { file -> file.mkdir() } }

        // TODO Manifest
        sourceMain.manifest.write(contentWriter, ContentContext("feature", "domain", packageName))
    }

    override fun visit(sourceTest: SourceTest) {
        // Source
        var folder = File(moduleContainer, sourceTest.sourcePath()).also { file -> file.mkdirs() }
        val packagesSplit = packageName.split(".")
        packagesSplit.forEach { folder = File(folder, it).also { file -> file.mkdir() } } // TODO falta el feature name y layer

        // Mock marker
        sourceTest.mockMarkerFile.write(contentWriter)
    }

    override fun visit(buildGradle: GatewayBuildGradle) =
        contentWriter.write(buildGradle.relativePath(), content = buildGradle.asString(packageName))

    override fun visit(buildGradle: PresentationBuildGradle) =
        contentWriter.write(buildGradle.relativePath(), content = buildGradle.asString(packageName))
}