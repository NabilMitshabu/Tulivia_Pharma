//package com.example.tuliviapharma
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.compose.NavHost
//
//
//@Composable
//fun ProduitDetails(title: String, price: String, tag: String, imageRes: Int) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(16.dp)
//    ) {
//        Image(
//            painter = painterResource(id = imageRes),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .clip(RoundedCornerShape(16.dp)),
//            contentScale = ContentScale.Crop
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = tag, fontSize = 16.sp, color = Color.Gray)
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(text = price, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF64EEA8))
//    }
//}
//
//@Composable
//fun NavGraph(navController: NavController) {
//    NavHost(navController, startDestination = "produitsMedicaux") {
//        composable("produitsMedicaux") { ProduitsMedicaux(navController) }
//        composable(
//            "produitDetails/{title}/{price}/{tag}/{imageRes}",
//            arguments = listOf(
//                navArgument("title") { type = NavType.StringType },
//                navArgument("price") { type = NavType.StringType },
//                navArgument("tag") { type = NavType.StringType },
//                navArgument("imageRes") { type = NavType.IntType }
//            )
//        ) { backStackEntry ->
//            val title = backStackEntry.arguments?.getString("title")!!
//            val price = backStackEntry.arguments?.getString("price")!!
//            val tag = backStackEntry.arguments?.getString("tag")!!
//            val imageRes = backStackEntry.arguments?.getInt("imageRes")!!
//            ProduitDetails(title, price, tag, imageRes)
//        }
//    }
//}
