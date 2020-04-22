package com.delbel.zygote.module.content.source

import com.delbel.zygote.module.content.dynamic.ManifestFile

class MainSource : Source() {

    override val manifest = ManifestFile()

    override fun src() = "src/main"

    override fun resources() = "src/main/res"
}