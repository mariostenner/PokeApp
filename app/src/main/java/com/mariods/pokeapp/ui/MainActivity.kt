package com.mariods.pokeapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mariods.pokeapp.ui.navigation.auth.AuthNavigationWrapper
import com.mariods.pokeapp.ui.screens.login.LoginScreen
import com.mariods.pokeapp.ui.theme.PokeAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.jvm.Throws

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    AuthNavigationWrapper()
                }
            }
        }
    }
}