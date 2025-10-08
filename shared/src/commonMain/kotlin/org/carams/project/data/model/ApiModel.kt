package org.carams.project.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data  class ApiResponse(
    val results: List<HeroVO>,
    @SerialName("response")
    val response: String
)

@Serializable
data class HeroVO(
    val id: String,
    val name: String
)