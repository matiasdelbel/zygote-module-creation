package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.files.Manifest
import com.delbel.zygote.feature.module.gradle.DomainBuildGradle
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
    }

    override fun visit(sourceTest: SourceTest) {
        // Source
        var folder = File(moduleContainer, sourceTest.sourcePath()).also { file -> file.mkdirs() }
        val packagesSplit = packageName.split(".")
        packagesSplit.forEach { folder = File(folder, it).also { file -> file.mkdir() } } // TODO falta el feature name y layer

        // Mock marker
        sourceTest.mockMarkerFile.write(contentWriter)
    }

    override fun visit(manifest: Manifest) =
        contentWriter.write(manifest.relativePath(), content = manifest.asString(packageName)) // TODO falta el feature name y layer

    override fun visit(buildGradle: DomainBuildGradle) =
        contentWriter.write(buildGradle.relativePath(), content = buildGradle.asString())

    override fun visit(buildGradle: GatewayBuildGradle) =
        contentWriter.write(buildGradle.relativePath(), content = buildGradle.asString(packageName))

    override fun visit(buildGradle: PresentationBuildGradle) =
        contentWriter.write(buildGradle.relativePath(), content = buildGradle.asString(packageName))
}