package org.carams.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.carams.project.mvvm.ArticlesViewModel
import org.carams.project.screens.ArticlesScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(articlesViewModel: ArticlesViewModel?) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ArticlesScreen(articlesViewModel = articlesViewModel)
        }
    }
}