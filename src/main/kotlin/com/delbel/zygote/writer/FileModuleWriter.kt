package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.GitIgnore
import com.delbel.zygote.feature.module.ProGuard
import java.io.File

class FileModuleWriter(parent: File) : ModuleWriter<File>(parent) {

    override fun visit(proguard: ProGuard) {
        val proGuardOrigin = readFromResource(file = ROUTE_TO_GIT_PRO_GUARD_ORIGIN)
        val proGuardDestination = File(parent, PRO_GUARD_FILE_NAME)

        proGuardOrigin.copyTo(proGuardDestination, overwrite = true)
    }

    override fun visit(gitIgnore: GitIgnore) {
        val gitIgnoreOrigin = readFromResource(file = ROUTE_TO_GIT_IGNORE_ORIGIN)
        val gitIgnoreDestination = File(parent, GIT_IGNORE_FILE_NAME)

        gitIgnoreOrigin.copyTo(gitIgnoreDestination, overwrite = true)
    }

    private fun readFromResource(file: String) = File(ModuleWriter::class.java.getResource(file).toURI())

    companion object {
        private const val ROUTE_TO_GIT_PRO_GUARD_ORIGIN = "/module/proguard-rules.pro"
        private const val ROUTE_TO_GIT_IGNORE_ORIGIN = "/module/.gitignore"

        private const val PRO_GUARD_FILE_NAME = "proguard-rules.pro"
        private const val GIT_IGNORE_FILE_NAME = ".gitignore"
    }
}