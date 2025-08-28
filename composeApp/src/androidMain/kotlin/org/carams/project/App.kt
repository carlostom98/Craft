package org.carams.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.carams.project.screens.AboutScreen
import org.carams.utils.IGetItems
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(getItems: IGetItems) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AboutScreen(getItems)
        }
    }
}