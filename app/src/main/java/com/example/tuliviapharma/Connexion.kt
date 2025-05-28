package com.example.tuliviapharma

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.tuliviapharma.composant.PasswordFieldWithIcon
import com.example.tuliviapharma.composant.TextFieldWithIcon
import com.example.tuliviapharma.ui.theme.TuliviaPharmaTheme


@Composable
fun Connexion(navController: androidx.navigation.NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF5FC)) // Fond rose pâle
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .background(Color(0xFF00CDBD)),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(40.dp))
                Text("Sign In", color = Color.White)

                Spacer(modifier = Modifier.height(24.dp))
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Via Pharma",
                        color = Color(0xFF00CDBD),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(top = 260.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Spacer(modifier = Modifier.height(12.dp))

            // Champ Email
            TextFieldWithIcon(
                label = "Entrer Email",
                icon = { Icon(Icons.Filled.Email, contentDescription = null) },
                value = email,
                onValueChange = { email = it }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Mot de passe
            PasswordFieldWithIcon(
                value = password,
                onValueChange = { password = it }
            )

            Spacer(modifier = Modifier.height(12.dp))


            Spacer(modifier = Modifier.height(24.dp))

            // Bouton Sing Up
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00CDBD))
            ) {
                Text("Sing Up", color = Color.White)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.Center) {
                Text("Don't have account ?")
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    "Sign Up",
                    color = Color(0xFF00CDBD),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text("Or sign in with")

            Spacer(modifier = Modifier.size(150.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color.Gray),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_gmail),
                        contentDescription = "Google",
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Google")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1877F2)),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_facebook),
                        contentDescription = "Facebook",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Facebook", color = Color.White)
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingConnexion() {
    TuliviaPharmaTheme {
        Connexion( navController = rememberNavController() )
    }
}
