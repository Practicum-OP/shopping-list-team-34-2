package com.diego.shoping_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.diego.shoping_list.compose.TestDbProductScreen
import com.diego.shoping_list.compose.TestDbScreen
import com.diego.shoping_list.ui.theme.Shoping_listTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Shoping_listTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    TestDbScreen(modifier = Modifier.padding(innerPadding))
                    TestDbProductScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}