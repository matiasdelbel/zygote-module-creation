package com.delbel.zygote.writer

import com.delbel.zygote.feature.Feature
import com.delbel.zygote.feature.module.Module
import java.io.File

class FileWriter(featureName: String, packageName: String, root: File) : Writer<File>(featureName, packageName, root) {

    override fun visit(feature: Feature) {
        createDirectory(parent = root, name = featureName)
    }

    override fun visit(module: Module): FileModuleWriter {
        createDirectory(parent = root, name = "$featureName/${module.name}")

        return FileModuleWriter(moduleFolder = File(root, "$featureName/${module.name}"), packageName = packageName)
    }

    private fun createDirectory(parent: File, name: String) = File(parent, name).mkdir()
}