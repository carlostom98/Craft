package org.carams.utils

import org.carams.project.Platform

class GetItemsImplementation(
    private val platform: Platform = Platform()
): IGetItems {
    override fun getItems(): List<Pair<String, String>> {
        return  mutableListOf(
            Pair("Name", platform.osName),
            Pair("OS version", platform.osVersion),
            Pair("Device Model", platform.deviceModel),
            Pair("Density", platform.density.toString()),
        )
    }
}