package com.example.tuliviapharma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.tuliviapharma.ui.theme.TuliviaPharmaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TuliviaPharmaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                        padding ->
                    // On passe les paddings si nécessaire
                    Box(modifier = Modifier.padding(padding)) {
                        MyApp()
                    }

                }
            }
        }
    }
}