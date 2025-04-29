package com.example.tuliviapharma

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Accueil") {

        // Écran d'accueil avec image hexagonale
        composable("Accueil") {
            Accueil(navController)
        }

        // Écran des produits médicaux
        composable("produits") {
            ProduitsMedicaux(navController)
        }

        // Écran des détails du produit
        composable(
            route = "produitDetails/{title}/{price}/{description}/{tag}/{imageRes}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("price") { type = NavType.StringType },
                navArgument("tag") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("imageRes") { type = NavType.IntType }

            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title")!!
            val price = backStackEntry.arguments?.getString("price")!!
            val tag = backStackEntry.arguments?.getString("tag")!!
            val imageRes = backStackEntry.arguments?.getInt("imageRes")!!
            val description = backStackEntry.arguments?.getString("description")!!
            ProduitDetails(title, price, tag, imageRes, description,navController)
        }
    }
}
