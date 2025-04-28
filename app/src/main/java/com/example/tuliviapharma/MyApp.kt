package com.example.tuliviapharma

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Accueil") {

        // Écran d'accueil avec image hexagonale
        composable("Accueil") {
            Accueil( navController)
        }

        // Écran de liste des appartements
        composable("produits") {
            ProduitsMedicaux( navController)
        }


    }
}
