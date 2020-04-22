package com.delbel.zygote.writer

import com.github.ajalt.clikt.output.TermUi.echo
import java.io.*
import java.nio.file.Files
import java.nio.file.StandardCopyOption

interface ContentWriter {

    fun write(targetName: String, content: String)

    fun copy(targetName: String, sourcePath: String)

    fun append(targetName: String, content: String)
}

class FileContentWriter(private val root: File) : ContentWriter {

    private val logger: LogContentWriter = LogContentWriter(root)

    override fun write(targetName: String, content: String) {
        logger.write(targetName, content)

        val buildGradleFile = File(root, targetName)
        buildGradleFile.bufferedWriter().use { out -> out.write(content) }
    }

    override fun copy(targetName: String, sourcePath: String) {
        logger.copy(targetName, sourcePath)

        val sourceAsStream = ContentWriter::class.java.getResourceAsStream(sourcePath)
        val destination = File(root, targetName)

        Files.createDirectories(destination.parentFile.toPath())
        Files.createFile(destination.toPath())
        Files.copy(sourceAsStream, destination.toPath(), StandardCopyOption.REPLACE_EXISTING)
    }

    override fun append(targetName: String, content: String) {
        logger.append(targetName, content)

        val destination = File(root, targetName)
        FileOutputStream(destination, true).bufferedWriter().use { writer -> writer.appendln(content) }
    }
}

class LogContentWriter(private val root: File) : ContentWriter {

    override fun write(targetName: String, content: String) = echo(message = (" NEW file: $root/$targetName (dynamic content)"))

    override fun copy(targetName: String, sourcePath: String) = echo(message = (" NEW file: $root/$targetName (source: $sourcePath)"))

    override fun append(targetName: String, content: String) = echo(message = "APPENDED: $root/$targetName")
}