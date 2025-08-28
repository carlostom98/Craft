package org.carams.project.atoms

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        colors = TopAppBarColors(
            containerColor = Color.LightGray,
            scrolledContainerColor = Color.Magenta,
            navigationIconContentColor = Color.LightGray,
            titleContentColor = Color.Black,
            actionIconContentColor = Color.Black
        ),
        title = {
            Text("Android App")
        }
    )
}