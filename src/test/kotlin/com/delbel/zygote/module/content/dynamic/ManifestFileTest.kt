package com.delbel.zygote.module.content.dynamic

import org.junit.Assert.assertEquals
import org.junit.Test

class ManifestFileTest {

    @Test
    fun `content create an android manifest`() {
        val manifest = ManifestFile()

        val manifestAsString = manifest.content(packageName = "com.test")

        assertEquals(expected(), manifestAsString)
    }

    private fun expected() =
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?><manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" package=\"com.test\"></manifest>"
}