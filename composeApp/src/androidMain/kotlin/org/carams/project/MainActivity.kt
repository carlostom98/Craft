package org.carams.project

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import org.carams.utils.GetItemsImplementation
import org.carams.utils.IGetItems

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val getItems: IGetItems = GetItemsImplementation()

        setContent {
            App(getItems)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview(context: Context = LocalContext.current) {
    val getItems: IGetItems = GetItemsImplementation()
    App(getItems)
}