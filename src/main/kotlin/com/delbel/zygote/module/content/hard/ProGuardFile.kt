package com.delbel.zygote.module.content.hard

import com.delbel.zygote.module.Module

class ProGuardFile : HardContent() {

    override val name = "proguard-rules.pro"

    override val source = "/hard/proguard-rules.pro"

    override fun pathIn(module: Module) = module.relativePathFor(file = this)
}