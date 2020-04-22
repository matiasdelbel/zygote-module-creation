package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.files.Manifest
import com.delbel.zygote.feature.module.gradle.DomainBuildGradle
import com.delbel.zygote.feature.module.gradle.GatewayBuildGradle
import com.delbel.zygote.feature.module.gradle.PresentationBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest
import java.io.File

class FileModuleWriter(moduleFolder: File, packageName: String) : ModuleWriter<File>(moduleFolder, packageName) {

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
        val staticContentWriter = FileHardContentWriter(module = moduleContainer)
        sourceTest.mockMarkerFile.write(staticContentWriter)
    }

    override fun visit(manifest: Manifest) {
        val manifestFile = File(moduleContainer, manifest.relativePath())
        manifestFile.bufferedWriter().use { out -> out.write(manifest.asString(packageName)) } // TODO falta el feature name y layer
    }

    override fun visit(buildGradle: DomainBuildGradle) {
        val buildGradleFile = File(moduleContainer, buildGradle.relativePath())
        buildGradleFile.bufferedWriter().use { out -> out.write(buildGradle.asString()) }
    }

    override fun visit(buildGradle: GatewayBuildGradle) {
        val buildGradleFile = File(moduleContainer, buildGradle.relativePath())
        buildGradleFile.bufferedWriter().use { out -> out.write(buildGradle.asString(packageName)) }
    }

    override fun visit(buildGradle: PresentationBuildGradle) {
        val buildGradleFile = File(moduleContainer, buildGradle.relativePath())
        buildGradleFile.bufferedWriter().use { out -> out.write(buildGradle.asString(packageName)) }
    }

    private fun copy(originPath: String, destinationRelativePath: String) {
        val origin = readFromResource(file = originPath)
        val destination = File(moduleContainer, destinationRelativePath)

        origin.copyTo(destination, overwrite = true)
    }

    private fun readFromResource(file: String) = File(ModuleWriter::class.java.getResource(file).toURI())
}