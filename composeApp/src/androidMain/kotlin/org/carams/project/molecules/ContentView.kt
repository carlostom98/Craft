package org.carams.project.molecules

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.carams.utils.IGetItems

@Composable
fun ContentView(getItems: IGetItems) {
    val items = getItems.getItems()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items) { rowItem ->
            RowView(rowItem)
        }
    }

}