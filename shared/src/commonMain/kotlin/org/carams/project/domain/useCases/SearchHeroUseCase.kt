package org.carams.project.domain.useCases

import org.carams.project.data.model.IHeroRepository
import org.carams.project.data.repository.HeroRepositoryImpl
import org.carams.project.domain.entities.HeroEntity

class SearchHeroUseCase(private val heroRepository: IHeroRepository = HeroRepositoryImpl()) {
    suspend operator fun invoke(name: String): Result<List<HeroEntity>> {
        return try {
            val results = heroRepository.getHero(name)
            if (results.isNotEmpty()) {
                Result.success(results)
            } else {
                Result.failure(ApiResponseIsEmptyException(MESSAGE, TAG))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    companion object {
        private const val MESSAGE = "Api response is empty"
        private const val TAG = "SearchHeroUseCase"
    }
}

class ApiResponseIsEmptyException(message: String, tag: String): Exception(message)