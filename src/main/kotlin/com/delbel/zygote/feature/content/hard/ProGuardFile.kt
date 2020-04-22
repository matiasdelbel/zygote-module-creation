package com.delbel.zygote.feature.content.hard

import com.delbel.zygote.feature.Module

class ProGuardFile : HardContent() {

    override val name = "proguard-rules.pro"

    override val source = "/hard/proguard-rules.pro"

    override fun pathIn(module: Module) = module.relativePathFor(file = this)
}