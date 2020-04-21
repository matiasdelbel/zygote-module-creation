package com.delbel.zygote.writer

import com.delbel.zygote.feature.Feature
import com.delbel.zygote.feature.module.Module
import java.io.File

class FileWriter(root: File) : Writer<File>(root) {

    override fun visit(feature: Feature) {
        createDirectory(parent = root, name = feature.name)
    }

    override fun visit(module: Module): FileModuleWriter {
        createDirectory(parent = root, name = module.path())

        return FileModuleWriter(parent = File(root, module.path()))
    }

    private fun createDirectory(parent: File, name: String) = File(parent, name).mkdir()
}