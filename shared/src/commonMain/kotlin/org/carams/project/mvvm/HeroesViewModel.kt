package org.carams.project.mvvm

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.carams.project.domain.UseCasesRouter
import org.carams.project.states.HeroesState

class HeroesViewModel(
    private val useCasesRouter: UseCasesRouter = UseCasesRouter()
): BaseViewModel() {

    private val _heroesState = MutableStateFlow<HeroesState>(HeroesState())
    val heroesState: StateFlow<HeroesState> get() = _heroesState.toMultiplatform(scope)

    fun userIntent(userIntent: UserIntent) {
        when(userIntent) {
            is UserIntent.SearchHeroes -> searchSuperHero(userIntent.name)
        }
    }

    sealed class UserIntent {
        data class SearchHeroes(val name: String): UserIntent()
    }

    private fun searchSuperHero(name: String) {
        scope.launch {
            useCasesRouter.searchHeroUseCase(name).fold(
                onSuccess = { heroesList ->
                    _heroesState.update {
                       it.copy(heroes = heroesList)
                    }
                },
                onFailure = { exception ->
                    _heroesState.update {
                        it.copy(error = exception.message)
                    }
                }
            )
        }
    }
}