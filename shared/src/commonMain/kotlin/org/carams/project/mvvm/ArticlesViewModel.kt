package org.carams.project.mvvm

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.carams.project.data.Secrets
import org.carams.project.domain.UseCasesRouter
import org.carams.project.states.ArticleEntity
import org.carams.project.states.ArticleState

class ArticlesViewModel: BaseViewModel() {
    private val _articlesState = MutableStateFlow<ArticleState>(ArticleState())
    val articlesState get() = _articlesState.toMultiplatform(scope)

    fun userIntent(userIntent: UserIntent) {
        when(userIntent) {
            UserIntent.GET_ALL -> getArticles()
            UserIntent.INSERT_OR_UPDATE_ARTICLE -> getArticles()
            UserIntent.DELETE_ARTICLE -> getArticles()
        }
    }

    fun getArticles() {
        scope.launch {
            _articlesState.update {
                getListOfArticles()?.let { listOfValues ->
                    it.copy(articles = listOfValues)
                } ?: it.copy(error = ERROR_MESSAGE)
            }
        }
    }

    private suspend fun getListOfArticles(): List<ArticleEntity>? {
        return articlesList
    }

    companion object {
        private val articlesList = listOf(
            ArticleEntity(name = "BBC", imageUrl = "https://d.newsweek.com/en/full/881613/33-bbc-breaking-news.webp", description = "A rare and potentially groundbreaking natural phenomenon has been discovered deep within Washington State’s Olympic National Forest: a 20-acre grove where trees appear to emit a soft, bioluminescent glow. Scientists are calling it the \"Luminous Canopy\" — a term that may soon become a fixture in ecological textbooks."),
            ArticleEntity(name = "NY Times", imageUrl = "https://diplo-media.s3.eu-central-1.amazonaws.com/2024/10/new-york-times-perplexity-ai-content.png", "Nestled in a remote quadrant of Olympic National Forest, a surreal sight has captured the attention of scientists and mystics alike: a softly glowing forest that appears to shine under the night sky without any visible light source."),
            ArticleEntity(name = "UCLA", imageUrl = "https://conferences.ucla.edu/wp-content/uploads/2021/01/uclalogo.png", "Several UCLA environmental science grad students and faculty members are heading north to join the ongoing research into the “Luminous Canopy,” a forest area in Washington where trees are reportedly glowing at night."),
        )

        private val articlesListNull = null

        private const val  ERROR_MESSAGE = "Server error, data not founded, hhttpCode: 500"
    }

    enum class UserIntent {
        GET_ALL,
        INSERT_OR_UPDATE_ARTICLE,
        DELETE_ARTICLE
    }


}