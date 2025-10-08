package org.carams.project.data

import org.carams.project.shared.BuildConfig

actual object Secrets {
    actual val API_AUTH_TOKEN: String
        get() = BuildConfig.AUTH_TOKEN
}