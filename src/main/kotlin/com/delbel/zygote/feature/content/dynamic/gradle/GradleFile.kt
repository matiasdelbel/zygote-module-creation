package com.delbel.zygote.feature.content.dynamic.gradle

import com.delbel.zygote.feature.content.dynamic.DynamicContent

abstract class GradleFile : DynamicContent() {

    abstract fun content(innerDependencies: List<String> = emptyList()): String
}