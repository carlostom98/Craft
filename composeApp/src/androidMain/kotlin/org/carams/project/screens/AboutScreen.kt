package org.carams.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import org.carams.project.atoms.Toolbar
import org.carams.utils.IGetItems

@Composable
fun AboutScreen(getItems: IGetItems) {
    Column {
        Toolbar()
    }
}
