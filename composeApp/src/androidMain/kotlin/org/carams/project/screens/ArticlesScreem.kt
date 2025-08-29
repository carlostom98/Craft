package org.carams.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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

    val articlesState = articlesViewModel?.articlesState?.collectAsState()

    Column {
        Toolbar()
        if (articlesState?.value?.loading == true) {
            Loader()
        } else if (articlesState?.value?.error != null) {
            ErrorMessage(articlesState.value.error ?: "Unknown error")
        } else {
            ArticlesListView(articlesState?.value?.articles ?: emptyList())
        }

    }

}