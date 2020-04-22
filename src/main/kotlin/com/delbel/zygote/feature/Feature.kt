package com.delbel.zygote.feature

import com.delbel.zygote.writer.*

class Feature(private val name: String, private val modules: List<Module> = emptyList()) {

    fun create(containerWriter: ContainerWriter, contentWriter: FileContentWriter) {
        containerWriter.create(name)
        // TODO update settings file

        modules.forEach { module ->
            val modulePath = "$name/${module.name}"
            module.create(containerWriter.clone(subPath = modulePath), contentWriter.clone(subPath = modulePath))
        }
    }
}