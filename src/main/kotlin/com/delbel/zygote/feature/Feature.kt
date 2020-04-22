package com.delbel.zygote.feature

import com.delbel.zygote.feature.module.Module
import com.delbel.zygote.writer.*
import java.io.File

class Feature(
    val root: File,
    private val modules: List<Module> = emptyList()
) {

    fun create() {
        createDirectory(parent = root, name = "feature")

        val featureFile = File(root, "feature")
        modules.forEach {
            it.create(
                containerWriter = DirectoryContainerWriter(module = File(featureFile, it.name)),
                contentWriter = FileContentWriter(module = File(featureFile, it.name))
            )
        }
    }

    private fun createDirectory(parent: File, name: String) = File(parent, name).mkdir()
}