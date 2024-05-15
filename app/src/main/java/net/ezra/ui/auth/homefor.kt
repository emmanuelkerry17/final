package net.ezra.ui.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_POST
import net.ezra.navigation.ROUTE_SHOW
import net.ezra.ui.home.BottomBar
import net.ezra.ui.home.HomeScreen
import net.ezra.ui.home.ScaffoldWithBottomMenu


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Homefor(navController: NavHostController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .padding(top = 10.dp)
            .background(Color.White)


    ) {

        var searchbar by rememberSaveable {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = searchbar,
            onValueChange = { searchbar = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
            placeholder = { Text(text = "Search") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .height(45.dp)
        )

        Row {
            Card(
                modifier = Modifier
                    .width(170.dp)
                    .height(170.dp)
                    .padding(10.dp)
                    .padding(10.dp)
                    .background(Color(0xff75d6ee))

            )
            {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "",
                        modifier = Modifier
                            .size(70.dp)
                            .clickable {
                                navController.navigate(ROUTE_POST) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                }
                            },
                    )
                    Text(
                        text = "Post",
//                Modifier.padding(10.dp)
                    )

                }

            }
            Spacer(
                modifier = Modifier
                    .width(20.dp)
            )

            Card(
                modifier = Modifier
                    .width(170.dp)
                    .height(170.dp)
                    .padding(10.dp)
                    .padding(10.dp)
                    .background(Color(0xff75d6ee))


            )
            {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.workers),
                        contentDescription = "",
                        modifier = Modifier
                            .size(70.dp)
                            .clickable {
                                navController.navigate(ROUTE_SHOW) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                }
                            },
                    )
                    Text(
                        text = "Work",
//                Modifier.padding(10.dp)
                    )

                }


            }


        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        Column {
            Card(
                modifier = Modifier
                    .width(170.dp)
                    .height(170.dp)
                    .padding(10.dp)
                    .padding(10.dp)
                    .background(Color(0xff75d6ee))


            )
            {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.getservice),
                        contentDescription = "",
                        modifier = Modifier
                            .size(70.dp)
                            .clickable {
                                navController.navigate(ROUTE_ABOUT) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                }
                            },
                    )
                    Text(
                        text = "About",
//                Modifier.padding(10.dp)
                    )

                }
            }


        }
    }
   


}

@Preview(showBackground = true)
@Composable
fun PreviewkLight() {
    Homefor(rememberNavController())
}




