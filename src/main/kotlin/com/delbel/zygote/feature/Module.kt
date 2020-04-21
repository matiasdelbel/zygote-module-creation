package com.delbel.zygote.feature

import com.delbel.zygote.feature.module.GitIgnore
import com.delbel.zygote.feature.module.ProGuard
import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

class Module(
    private val parent: String,
    private val name: String,
    private val proGuard: ProGuard? = null,
    private val gitIgnore: GitIgnore? = null
) : Writeable {

    override fun <T> create(writer: Writer<T>) {
        val moduleWriter = writer.visit(module = this)

        proGuard?.create(moduleWriter)
        gitIgnore?.create(moduleWriter)

        // TODO append on settings.gradle.kts the module
    }

    fun path() = "$parent/$name"
}