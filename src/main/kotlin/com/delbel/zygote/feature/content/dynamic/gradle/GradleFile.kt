package com.delbel.zygote.feature.content.dynamic.gradle

import com.delbel.zygote.feature.Module
import com.delbel.zygote.feature.content.dynamic.DynamicContent

abstract class GradleFile : DynamicContent() {

    override fun pathIn(module: Module) = module.relativePathFor(file = this)

    abstract fun content(innerDependencies: List<String> = emptyList()): String
}