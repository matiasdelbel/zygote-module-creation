package com.delbel.zygote.writer

import com.delbel.zygote.feature.Feature
import com.delbel.zygote.feature.module.Module
import java.io.File

class FileWriterDeprecated(featureName: String, packageName: String, root: File) : Writer<File>(featureName, packageName, root) {

    override fun visit(feature: Feature) {
        createDirectory(parent = root, name = featureName)
    }

    override fun visit(module: Module): Pair<FileModuleWriter, HardContentWriter> {
        createDirectory(parent = root, name = "$featureName/${module.name}")

        val moduleFolder = File(root, "$featureName/${module.name}")

        val moduleWriter =  FileModuleWriter(moduleFolder = moduleFolder, packageName = packageName)
        val staticContentWriter = FileHardContentWriter(module = moduleFolder)

        return Pair(moduleWriter, staticContentWriter)
    }

    private fun createDirectory(parent: File, name: String) = File(parent, name).mkdir()
}