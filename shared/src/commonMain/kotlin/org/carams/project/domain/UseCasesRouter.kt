package org.carams.project.domain

import org.carams.project.domain.useCases.SearchHeroUseCase

data class UseCasesRouter(val searchHeroUseCase: SearchHeroUseCase = SearchHeroUseCase())
