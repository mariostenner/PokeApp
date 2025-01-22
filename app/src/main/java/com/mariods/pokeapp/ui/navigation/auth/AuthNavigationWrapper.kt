package com.mariods.pokeapp.ui.navigation.auth

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mariods.pokeapp.ui.screens.login.LoginScreen
import com.mariods.pokeapp.ui.screens.main.MainScreen
import com.mariods.pokeapp.ui.screens.signup.SignupScreen
import com.mariods.pokeapp.ui.screens.splash.SplashScreen

@Composable
fun AuthNavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Splash) {

        composable<Splash> {
            SplashScreen(
                {
                    navController.navigate(Login) {
                        popUpTo<Splash> { inclusive = true }
                    }
                })
        }


        composable<Login> {
            LoginScreen(
                { navController.navigate(Main) },
                { navController.navigate(Signup) }
            )
        }

        composable<Signup> {
            SignupScreen({ navController.navigate(Login) })
        }


        composable<Main> {
            MainScreen()
        }
    }
}