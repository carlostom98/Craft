package org.carams.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.carams.project.atoms.ErrorMessage
import org.carams.project.atoms.Loader
import org.carams.project.atoms.Toolbar
import org.carams.project.molecules.ArticlesListView
import org.carams.project.mvvm.ArticlesViewModel

@Composable
fun ArticlesScreen(articlesViewModel: ArticlesViewModel?) {
    LaunchedEffect(Unit) {
        articlesViewModel?.userIntent(ArticlesViewModel.UserIntent.GET_ALL)
    }

    val articlesState = articlesViewModel?.articlesState?.collectAsStateWithLifecycle()

    Column {
        Toolbar()
        articlesState?.value?.let { state ->
            if (state.loading) {
                Loader()
            } else if (state.error != null) {
                ErrorMessage(articlesState.value.error ?: "Unknown error")
            } else {
                ArticlesListView(state.articles)
            }
        }

    }

}