package org.carams.project

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val batteryManager = BatteryManager(this)

        setContent {
            App(batteryManager)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview(context: Context = LocalContext.current) {
    val batteryManager = BatteryManager(context)
    App(null)
}