package com.delbel.zygote.feature.content.source

import com.delbel.zygote.feature.content.dynamic.ManifestFile
import com.delbel.zygote.feature.module.Module

class MainSource : Source() {

    override val manifest = ManifestFile()

    override fun path(module: Module): String = "src/main/kotlin/"
}