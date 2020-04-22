package com.delbel.zygote.feature

import com.delbel.zygote.feature.content.source.Source

data class Feature(private val name: String, private val basePackage: String) {

    fun packageNameFor(module: Module) =
        "$basePackage.$name.${module.name}"

    fun dependencyNameFor(module: Module) =
        ":$name:${module.name}"

    fun sourcePathFor(module: Module, source: Source) =
        "${source.path()}/${basePackage.split(".").joinToString("/")}/${module.name}"
}