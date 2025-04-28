package com.example.tuliviapharma

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tuliviapharma.ui.theme.TuliviaPharmaTheme


@Composable
fun ProduitsMedicaux( navController: NavController) {
    val produits = listOf(
        Produit("Atenolol", "20€", "Santé cardiaque", R.drawable.atenolol),
        Produit("Bétadine", "6€", "Soins de la peau", R.drawable.betadine),
        Produit("Insuline", "18€", "Régulation de la glycémie", R.drawable.insulina),
        Produit("Oméprazole", "15€", "Protection gastrique", R.drawable.omeprazol),
        Produit("Lévétiracétam", "22€", "Traitement de l'épilepsie", R.drawable.levitiracetame)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Barre du haut avec icône de retour et titre
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Retour",
                tint = Color(0xFF14E37E),
                modifier = Modifier.clickable { navController.navigate("Accueil") }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Retour", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
        ) {
            items(produits) { produit ->
                ProduitCard(produit)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

data class Produit(
    val title: String,
    val price: String,
    val tag: String,
    val imageRes: Int
)

@Composable
fun ProduitCard(produit: Produit) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = produit.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(95.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = produit.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = produit.tag,
                    fontSize = 12.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = produit.price,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF64EEA8)
                )
            }

            IconButton(
                onClick = { /* Ajouter au panier */ },
                modifier = Modifier
                    .size(36.dp)
                    .background(Color(0xFFE0F6EC), RoundedCornerShape(12.dp))
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Ajouter au panier",
                    tint = Color(0xFF45EF99)
                )
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TuliviaPharmaTheme {
        ProduitsMedicaux( navController = rememberNavController())
    }
}
