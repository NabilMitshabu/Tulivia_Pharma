package com.example.tuliviapharma

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tuliviapharma.ui.theme.TuliviaPharmaTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Accueil( navController: NavController) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .semantics { isTraversalGroup = true }
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(24.dp))

            HorizontalPager(state = pagerState) { page ->
                val image = when (page) {
                    0 -> R.drawable.pharma
                    1 -> R.drawable.pharma1
                    else -> R.drawable.phama2
                }
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(250.dp, 300.dp)
                            .clip(RoundedCornerShape(40.dp))
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(if (pagerState.currentPage == index) 24.dp else 6.dp, 6.dp)
                            .background(
                                if (pagerState.currentPage == index) Color(0xFF14E37E) else Color.LightGray,
                                RoundedCornerShape(3.dp)
                            )
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            val titles = listOf(
                buildAnnotatedString {
                    withStyle(SpanStyle(color = Color(0xFF14E37E), fontWeight = FontWeight.Bold)) {
                        append("TULIVIA PHARMA, ")
                    }
                    withStyle(SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                        append("VOTRE SANTÉ D'ABORD")
                    }
                },
                buildAnnotatedString {
                    withStyle(SpanStyle(color = Color.Black)) {
                        append("DES MÉDICAMENTS ")
                    }
                    withStyle(SpanStyle(color = Color(0xFF14E37E), fontWeight = FontWeight.Bold)) {
                        append("SPÉCIALISÉS")
                    }
                    withStyle(SpanStyle(color = Color.Black)) {
                        append(" À PORTÉE DE MAIN")
                    }
                },
                buildAnnotatedString {
                    withStyle(SpanStyle(color = Color.Black)) {
                        append("UN CONSEIL ")
                    }
                    withStyle(SpanStyle(color = Color(0xFF14E37E), fontWeight = FontWeight.Bold)) {
                        append("PERSONNALISÉ")
                    }
                    withStyle(SpanStyle(color = Color.Black)) {
                        append(" POUR CHAQUE CLIENT")
                    }
                }
            )

            val descriptions = listOf(
                "Des produits fiables et de qualité pour\n obtenir tous vos besoins médicaux\n simplement et rapidement.",
                "Accédez à une large gamme de produits\n sans vous déplacer. Commandez en\n toute simplicité.",
                "Notre équipe vous accompagne pour\n choisir le traitement le plus adapté\n à vos besoins."
            )

            AnimatedContent(targetState = pagerState.currentPage, label = "title") { page ->
                Text(
                    text = titles[page],
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            AnimatedContent(targetState = pagerState.currentPage, label = "description") { page ->
                Text(
                    text = descriptions[page],
                    fontSize = 16.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    if (pagerState.currentPage < pagerState.pageCount - 1) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        navController.navigate("produits")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF14E37E)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Next", color = Color.White)
            }
        }

        Text(
            text = "Skip",
            color = Color(0xFF14E37E),
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .clickable {
                    navController.navigate("produits")
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting() {
    TuliviaPharmaTheme {
        Accueil( navController = rememberNavController())
    }
}