package com.delbel.zygote.feature

import com.delbel.zygote.feature.top.GitIgnore
import com.delbel.zygote.feature.top.ProGuard
import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

class Module private constructor(
    val parent: String,
    val name: String,
    private val proGuard: ProGuard?,
    private val gitIgnore: GitIgnore?
) : Writeable {

    override fun <T> create(writer: Writer<T>) {
        writer.visit(module = this)
        proGuard?.create(writer)
        gitIgnore?.create(writer)
    }

    class Builder(private val name: String) {

        private var parent: String = ""
        private var proGuard: ProGuard? = null
        private var gitIgnore: GitIgnore? = null

        fun withParent(name: String): Builder {
            parent = name
            if (proGuard != null) proGuard = ProGuard("$parent/${this.name}")
            if (gitIgnore != null) gitIgnore = GitIgnore("$parent/${this.name}")

            return this
        }

        fun withProguard(): Builder {
            proGuard = ProGuard(parent = name)
            return this
        }

        fun withGitIgnore(): Builder {
            gitIgnore = GitIgnore(parent = name)
            return this
        }

        fun build() = Module(parent, name, proGuard, gitIgnore)
    }
}