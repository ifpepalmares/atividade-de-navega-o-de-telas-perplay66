package com.example.composenavigationapp

import android.R.attr.onClick
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigationapp.ui.theme.ComposeNavigationAppTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen_a") {
        composable("screen_a") {
            ScreenA(navController = navController)
        }
        composable("screen_b?message={message}") {
            val message = it.arguments?.getString("message")
            ScreenB(navController = navController, message = message)
        }
        composable("screen_c") {
            ScreenC(navController = navController)
        }
    }
}


@Composable
fun ScreenA(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.estilo_gourmet_em_tons_quentes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "🍔 Best Burguer",
                style = MaterialTheme.typography.headlineMedium,
                color = colorResource(R.color.red)
            )

            Text(
                text = "Bem-vindo!",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp, bottom = 24.dp)
            )

            Button(onClick = {
                navController.navigate("screen_b?message=Produtos em breve")
            }) {
                Text("Produtos")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                navController.navigate("screen_c")
            }) {
                Text("Contato")
            }
        }
    }
}
@Composable
fun ScreenB(navController: NavController, message: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Nosso Cardápio",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFFEF6C00)

        )

        Spacer(modifier = Modifier.padding(12.dp))

        // Produto 1
        Text(text = "🍔 X-Burguer")
        Text(text = "R$ 15,00")

        Spacer(modifier = Modifier.padding(12.dp))

        // Produto 2
        Text(text = "🍔 X-Salada")
        Text(text = "R$ 18,00")

        Spacer(modifier = Modifier.padding(12.dp))

        // Produto 3
        Text(text = "🍔 X-Bacon")
        Text(text = "R$ 20,00")

        Spacer(modifier = Modifier.padding(24.dp))

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Voltar")
        }
    }
}
@Composable
fun ScreenC(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Contato",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFFEF6C00)
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = "📍 Rua das Flores, 123")
        Text(text = "📞 (81) 99999-9999")
        Text(text = "✉ suporte@bestburguer.com")

        Spacer(modifier = Modifier.padding(24.dp))

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Voltar")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ScreenAPreview() {
    ComposeNavigationAppTheme {
        ScreenA(rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenBPreview() {
    ComposeNavigationAppTheme {
        ScreenB(rememberNavController(), "Olá da Tela A")
    }
}
@Preview(showBackground = true)
@Composable
fun ScreenCPreview() {
    ComposeNavigationAppTheme {
        ScreenC(rememberNavController())
    }
}
