package org.carams.project.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.carams.project.domain.entities.HeroEntity

@Serializable
data  class ApiResponse(
    @SerialName("response") val response: String,
    @SerialName("results") val results: List<HeroVO>,
)

@Serializable
data class HeroVO(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String
)

fun HeroVO.toHeroEntity() = with(this) {
    HeroEntity(id = id, name = name)
}