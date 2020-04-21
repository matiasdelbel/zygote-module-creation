package com.delbel.zygote.writer

import com.delbel.zygote.feature.Feature
import com.delbel.zygote.feature.Module
import java.io.File

class FileWriter(root: File) : Writer<File>(root) {

    override fun visit(feature: Feature) {
        createFile(parent = root, name = feature.name)
    }

    override fun visit(module: Module) {
        createFile(parent = File(root, module.parent), name = module.name)
    }

    private fun createFile(parent: File, name: String) = File(parent, name).mkdir()
}