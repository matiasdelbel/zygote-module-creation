package com.delbel.zygote.writer

import com.delbel.zygote.feature.Feature
import com.delbel.zygote.feature.Module
import com.delbel.zygote.feature.top.GitIgnore
import com.delbel.zygote.feature.top.ProGuard
import java.io.File

class FileWriter(root: File) : Writer<File>(root) {

    override fun visit(feature: Feature) {
        createDirectory(parent = root, name = feature.name)
    }

    override fun visit(module: Module) {
        createDirectory(parent = File(root, module.parent), name = module.name)
    }

    override fun visit(proguard: ProGuard) {
        val proGuardOrigin = readFromResource(file = "/top/proguard-rules.pro")
        val proGuardDestination = File("$root/${proguard.parent}/proguard-rules.pro")

        proGuardOrigin.copyTo(proGuardDestination)
    }

    override fun visit(gitIgnore: GitIgnore) {
        val gitIgnoreOrigin = readFromResource(file = "/top/.gitignore")
        val gitIgnoreDestination = File("$root/${gitIgnore.parent}/.gitignore")

        gitIgnoreOrigin.copyTo(gitIgnoreDestination)
    }

    private fun createDirectory(parent: File, name: String) = File(parent, name).mkdir()

    private fun readFromResource(file: String) = File(FileWriter::class.java.getResource(file).toURI())
}