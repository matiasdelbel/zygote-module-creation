package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.GitIgnore
import com.delbel.zygote.feature.module.ProGuard
import com.delbel.zygote.feature.module.SourceTest
import java.io.File

class FileModuleWriter(parent: File) : ModuleWriter<File>(parent) {

    override fun visit(proguard: ProGuard) {
        val proGuardOrigin = readFromResource(file = ROUTE_TO_GIT_PRO_GUARD_ORIGIN)
        val proGuardDestination = File(parent, proGuardOrigin.name)

        proGuardOrigin.copyTo(proGuardDestination, overwrite = true)
    }

    override fun visit(gitIgnore: GitIgnore) {
        val gitIgnoreOrigin = readFromResource(file = ROUTE_TO_GIT_IGNORE_ORIGIN)
        val gitIgnoreDestination = File(parent, gitIgnore.name)

        gitIgnoreOrigin.copyTo(gitIgnoreDestination, overwrite = true)
    }

    override fun visit(sourceTest: SourceTest) {
        val mockMakerOrigin = readFromResource(file = ROUTE_TO_MOCK_MAKER_ORIGIN)

        val absolutePath = "$parent/${sourceTest.resourcesPath()}/mockito-extensions"
        val mockMakerDestination = File(absolutePath, MOCK_MAKER_FILE_NAME)

        mockMakerOrigin.copyTo(mockMakerDestination, overwrite = true)
    }

    private fun readFromResource(file: String) = File(ModuleWriter::class.java.getResource(file).toURI())

    companion object {
        private const val ROUTE_TO_GIT_PRO_GUARD_ORIGIN = "/module/proguard-rules.pro"
        private const val ROUTE_TO_GIT_IGNORE_ORIGIN = "/module/.gitignore"
        private const val ROUTE_TO_MOCK_MAKER_ORIGIN = "/module/org.mockito.plugins.MockMaker"

        private const val MOCK_MAKER_FILE_NAME = "org.mockito.plugins.MockMaker"
    }
}