package com.delbel.zygote

import com.delbel.zygote.module.*
import com.delbel.zygote.module.content.dynamic.gradle.DomainGradleFile
import com.delbel.zygote.module.content.dynamic.gradle.GatewayGradleFile
import com.delbel.zygote.module.content.dynamic.gradle.PresentationGradleFile
import com.delbel.zygote.module.Module
import com.delbel.zygote.module.content.dynamic.SettingsFile
import com.delbel.zygote.writer.DirectoryContainerWriter
import com.delbel.zygote.writer.FileContentWriter
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.output.TermUi.echo
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import com.github.ajalt.clikt.parameters.types.int
import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    echo(message = "WELCOME!")
    echo(message = "Please complete the following options to create the modules")
    echo(message = "")

    MainCommand().main(args)
}

class MainCommand : CliktCommand() {

    private val feature: String by option().prompt("Feature name: ")
    private val basePackage: String by option().prompt("Base package name: ")

    override fun run() {
        val feature = Feature(feature, basePackage)

        val domain = Module(
            name = "domain",
            feature = feature,
            buildGradle = DomainGradleFile()
        )
        val gateway = Module(
            name = "gateway",
            feature = feature,
            buildGradle = GatewayGradleFile(),
            innerDependencies = listOf(domain)
        )
        val presentation = Module(
            name = "presentation",
            feature = feature,
            buildGradle = PresentationGradleFile(),
            innerDependencies = listOf(domain)
        )

        listOf(domain, presentation, gateway).forEach { module ->
            module.create(
                containerWriter = DirectoryContainerWriter(root = File(root(), "feature")),
                contentWriter = FileContentWriter(root = File(root(), "feature"))
            )

            SettingsFile().write(writer = FileContentWriter(root = root()), module = module)
        }
    }

    private fun root(): File {
        val path = Paths.get("").toAbsolutePath().toString()
        return File(path)
    }
}