package org.carams.project.data.model

import org.carams.project.domain.entities.HeroEntity

interface IHeroRepository {
    suspend fun getHero(name: String): List<HeroEntity>
}