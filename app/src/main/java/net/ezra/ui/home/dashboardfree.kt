package net.ezra.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Dashprofile(navController: NavHostController) {
    ScaffoldWithBottomMenu(rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun Dashwith() {
    Dashprofile(rememberNavController())
}

