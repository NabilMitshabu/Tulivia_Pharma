package com.example.tuliviapharma

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Accueil") {

        composable("Accueil") {
            Accueil( navController)
        }

        composable("produits") {
            ProduitsMedicaux( navController)
        }


    }
}
