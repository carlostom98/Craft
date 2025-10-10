package org.carams.project.data.model

interface IHeroApiFramework {
    suspend fun getHero(name: String): List<HeroVO>
}