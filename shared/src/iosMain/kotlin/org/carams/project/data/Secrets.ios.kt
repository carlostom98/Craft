package org.carams.project.data

import platform.Foundation.NSBundle
import platform.Foundation.NSDictionary
import platform.Foundation.dictionaryWithContentsOfFile

actual object Secrets {
    actual val API_AUTH_TOKEN: String
        get() = getStringResource("Secrets", "plist", "authToken") ?: ""
}

internal fun getStringResource(
    fileName: String,
    fileType: String,
    valueKey: String
): String? {
    return NSBundle.mainBundle.pathForResource(fileName, fileType)?.let {
        val map = NSDictionary.dictionaryWithContentsOfFile(it)
        map?.get(valueKey) as? String
    }
}