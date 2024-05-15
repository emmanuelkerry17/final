package net.ezra.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.ezra.ui.SplashScreen
import net.ezra.ui.about.AboutScreen
import net.ezra.ui.auth.FirestoreViewModel
import net.ezra.ui.auth.Homefor
import net.ezra.ui.auth.ItemList
import net.ezra.ui.auth.LancerList
import net.ezra.ui.auth.LoginScreen
import net.ezra.ui.auth.SelectScreen

import net.ezra.ui.auth.SignUpScreen2
//import net.ezra.ui.auth.SignupScreen
//import net.ezra.ui.auth.SignupScreenfree

import net.ezra.ui.contact.ContactScreen
import net.ezra.ui.evening.EveningScreen
import net.ezra.ui.home.Dashprofile
import net.ezra.ui.home.HomeScreen

import net.ezra.ui.products.ProductsScreen
import net.ezra.ui.services.Postwork
import net.ezra.ui.services.ServicesScreen
import net.ezra.ui.shop.ShopScreen
import net.ezra.ui.students.AddStudents



@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH


) {
    BackHandler {
        navController.popBackStack()

        }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {


        composable(ROUTE_LOGIN) {
            LoginScreen(navController = navController){}
        }


//        composable(ROUTE_SIGNUP) {
//            SignupScreen(navController)
//        }
//

        composable(ROUTE_HOME) {
            Homefor(navController )
        }


        composable(ROUTE_ABOUT) {
            AboutScreen(navController)
        }

        composable(ROUTE_SERVICES) {
            ServicesScreen(navController)
        }

//        composable(ROUTE_MESSAGE) {
//            MessagingScreen(navController)
//        }

        composable(ROUTE_CONTACT) {
            ContactScreen(navController)
        }

        composable(ROUTE_SHOP) {
            ShopScreen(navController)
        }

        composable(ROUTE_PRODUCTS) {
            ProductsScreen(navController)
        }

        composable(ROUTE_EVENING) {
            EveningScreen(navController)
        }
        composable(ROUTE_ADD_STUDENTS) {
            AddStudents(navController)
        }

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }

//        composable(ROUTE_DISPLAY) {
//            WorkList(navController)
//        }

//        composable(ROUTE_RATING) {
//            Rating(navController = navController, viewModel = viewModel())
//        }
        composable(ROUTE_SIGNFREE) {
            SignUpScreen2(navController= navController){}
        }
        composable(ROUTE_SELECT) {
            SelectScreen(navController)
        }
        composable(ROUTE_DASHBOARD) {
            Dashprofile(navController)
        }
//        composable(ROUTE_OPTIONS) {
//            SelectableOutlinedTextField(navController){}
//        }
        composable(ROUTE_POST) {
            Postwork(navController)
        }
        composable(ROUTE_SHOW) {
            LancerList(navController = navController, viewModel = FirestoreViewModel())
        }



































    }
}