package com.diego.shoping_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.diego.shoping_list.presentation.navigation.AppNavGraph
import com.diego.shoping_list.ui.theme.Shoping_listTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Shoping_listTheme {
                AppNavGraph()
            }
        }
    }
}