package org.carams.project.states

import org.carams.project.domain.entities.HeroEntity

data class HeroesState(
    val heroes: List<HeroEntity> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
