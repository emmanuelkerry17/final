package net.ezra.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DrawerValue
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.material.bottomappbar.BottomAppBar
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MESSAGE
import net.ezra.navigation.ROUTE_SERVICES
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_EVENING
import net.ezra.navigation.ROUTE_PRODUCTS
import net.ezra.navigation.ROUTE_SHOP

import net.ezra.R
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_POST
import net.ezra.navigation.ROUTE_SHOW
import net.ezra.navigation.ROUTE_SIGNUP


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    ScaffoldWithBottomMenu(rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    HomeScreen(rememberNavController())
}






@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp, backgroundColor = (Color(0xff75d6ee))


    ) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            label = { Text(text = "Home") },
            selected = (navController.currentDestination?.route == "home"),
            onClick = {
                navController.navigate("home")
            })


        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person,"")
        },
            label = { Text(text = "About") },
            selected = (selectedIndex.value == 2),
            onClick = { navController.navigate(ROUTE_ABOUT) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }
            })
    }


}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldWithBottomMenu(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomBar(rememberNavController()) }
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()

        ) {
            item {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .padding(top = 10.dp)


                ) {

                    var searchbar by rememberSaveable {
                        mutableStateOf("")
                    }

                    OutlinedTextField(
                        value = searchbar,
                        onValueChange = { searchbar = it },
                        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription ="" )},
                        placeholder = { Text(text = "Search") },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier
                        .height(45.dp))

Row {
    Card(modifier = Modifier
        .width(170.dp)
        .height(170.dp)
        .padding(10.dp)
        .padding(10.dp)
        .background(Color(0xff75d6ee))

    )
    {
        Column(modifier = Modifier
            .padding(10.dp)
            .padding(10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.profile) ,
                contentDescription = "",
                modifier = Modifier
                    .size(70.dp)
                    .clickable {
                        navController.navigate(ROUTE_POST) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }
                    },
            )
            Text(text = "Post",
//                Modifier.padding(10.dp)
            )

        }

    }
    Spacer(modifier = Modifier
        .width(20.dp))

    Card(modifier = Modifier
        .width(170.dp)
        .height(170.dp)
        .padding(10.dp)
        .padding(10.dp)
        .background(Color(0xff75d6ee))


    )
    {
        Column(modifier = Modifier
            .padding(10.dp)
            .padding(10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.workers) ,
                contentDescription = "",
                modifier = Modifier
                    .size(70.dp),
            )
            Text(text = "Work",
//                Modifier.padding(10.dp)
            )

        }

    }



}
                    Spacer(modifier = Modifier
                        .height(20.dp))




                }
            }

        }
    }
}






