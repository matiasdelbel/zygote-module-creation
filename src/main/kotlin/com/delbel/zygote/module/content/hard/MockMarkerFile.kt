package com.delbel.zygote.module.content.hard

import com.delbel.zygote.module.Module

class MockMarkerFile : HardContent() {

    override val name: String = "mockito-extensions/org.mockito.plugins.MockMaker"

    override val source: String = "/hard/org.mockito.plugins.MockMaker"

    override fun pathIn(module: Module) = module.relativePathFor(file = this)
}