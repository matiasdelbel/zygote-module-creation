package com.delbel.zygote.module.content.dynamic

import com.delbel.zygote.module.Module
import java.io.StringWriter
import javax.xml.stream.XMLOutputFactory
import javax.xml.stream.XMLStreamWriter

class ManifestFile : DynamicContent() {

    override val name: String = "AndroidManifest.xml"

    override fun pathIn(module: Module) = module.relativePathFor(file = this)

    override fun content(module: Module) = module.contentFor(file = this)

    fun content(packageName: String): String {
        val stringWriter = StringWriter()
        val xmlWriter: XMLStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(stringWriter)

        xmlWriter.writeStartDocument("UTF-8", "1.0")
        xmlWriter.writeStartElement("manifest")
        xmlWriter.writeAttribute("xmlns:android", "http://schemas.android.com/apk/res/android")
        xmlWriter.writeAttribute("package", packageName)
        xmlWriter.writeEndElement()
        xmlWriter.writeEndDocument()
        xmlWriter.flush()
        stringWriter.flush()

        return stringWriter.buffer.toString()
    }
}