package org.carams.project.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.carams.project.states.ArticleEntity

@Composable
fun ArticlesListView(list: List<ArticleEntity>) {
    LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(list) { item ->
            ArticleItemView(item)
        }
    }
}

@Composable
fun ArticleItemView(articleEntity: ArticleEntity) {
    val spacerHeight = 16.dp
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
            model = articleEntity.imageUrl,
            contentDescription = "Image ${articleEntity.name}"
        )
        Spacer(modifier = Modifier.height(spacerHeight))
        Text(text = articleEntity.name, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp))
        Spacer(modifier = Modifier.height(spacerHeight))
        Text(text = articleEntity.description, style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 15.sp))
    }
}

