package com.delbel.zygote.feature.content.source

import com.delbel.zygote.feature.content.dynamic.ManifestFile

class MainSource : Source() {

    override val manifest = ManifestFile()

    override fun src() = "src/main"

    override fun resources() = "src/main/res"
}