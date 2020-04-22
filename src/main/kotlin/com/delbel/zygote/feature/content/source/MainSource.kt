package com.delbel.zygote.feature.content.source

import com.delbel.zygote.feature.content.dynamic.ManifestFile

class MainSource : Source() {

    override val manifest = ManifestFile()

    override fun path() = "src/main/kotlin"
}