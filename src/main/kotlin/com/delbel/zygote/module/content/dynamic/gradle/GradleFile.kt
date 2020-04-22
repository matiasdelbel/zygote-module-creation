package com.delbel.zygote.module.content.dynamic.gradle

import com.delbel.zygote.module.Module
import com.delbel.zygote.module.content.dynamic.DynamicContent

abstract class GradleFile : DynamicContent() {

    override fun pathIn(module: Module) = module.relativePathFor(file = this)

    abstract fun content(innerDependencies: List<String> = emptyList()): String
}