package org.carams.project.states


data class ArticleState(
    val articles: List<ArticleEntity> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
    )



data class ArticleEntity(val name: String, val imageUrl: String, val description: String)