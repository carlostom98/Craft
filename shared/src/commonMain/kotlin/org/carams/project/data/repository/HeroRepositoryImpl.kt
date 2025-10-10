package org.carams.project.data.repository

import org.carams.project.data.model.IHeroApiFramework
import org.carams.project.data.model.IHeroRepository
import org.carams.project.data.model.toHeroEntity
import org.carams.project.data.network.HeroApiFrameworkImpl
import org.carams.project.domain.entities.HeroEntity

class HeroRepositoryImpl(private val heroApiFrameworkImpl: IHeroApiFramework = HeroApiFrameworkImpl()) :
    IHeroRepository {

    override suspend fun getHero(name: String): List<HeroEntity> {
        return heroApiFrameworkImpl.getHero(name).map { it.toHeroEntity() }
    }

}