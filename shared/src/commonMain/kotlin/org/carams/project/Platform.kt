package org.carams.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform