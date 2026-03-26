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
