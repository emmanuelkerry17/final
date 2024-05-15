package net.ezra.ui.about

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.ui.theme.AppTheme



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavHostController) {
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),


        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(ROUTE_HOME){
                        popUpTo(ROUTE_ABOUT){inclusive = true}
                    } }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription ="",
                            tint = Color.Black
                        )

                    }
                },
                title = {

                }, actions = {


                    IconButton(onClick = { navController.navigate(ROUTE_ABOUT){popUpTo(ROUTE_ABOUT){inclusive=true} } }) {
                        Icon(imageVector = Icons.Filled.Call, contentDescription ="",
                            tint = Color.Black )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(Color.DarkGray)
            )


        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center


                ) {
                    Spacer(modifier = Modifier.width(20.dp))
                    Image(painter = painterResource(id = R.drawable.service), contentDescription = "",
                        Modifier.padding(60.dp))
                }
            }

        }
    )


    Column(
        modifier = Modifier
            .fillMaxSize(),
//            .background(Color.Black),



        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom

    ){
        Card(
//            colors = CardDefaults.cardColors(Color(0xff1d142d),
//
//                )
//            ,
            modifier = Modifier
                .height(500.dp)
                .width(400.dp),
            elevation = CardDefaults.cardElevation(10.dp)




        ) {
            Card (
                modifier = Modifier
                    .height(50.dp)
                    .width(400.dp),
                elevation = CardDefaults.cardElevation(20.dp),
                shape = CutCornerShape(11.dp)



            ){
                Row {
                    Image(painter = painterResource(id = R.drawable.img_1), contentDescription ="" )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "@ Serviceteke",
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp)

                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Card (
                modifier = Modifier
                    .height(50.dp)
                    .width(400.dp),
                elevation = CardDefaults.cardElevation(20.dp),
                shape = CutCornerShape(11.dp)



            ){
                Row {
                    Image(painter = painterResource(id = R.drawable.img_3), contentDescription ="" )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "@ Serviceteke",
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp)

                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Card (
                modifier = Modifier
                    .height(50.dp)
                    .width(400.dp),
                elevation = CardDefaults.cardElevation(20.dp),
                shape = CutCornerShape(11.dp)



            ){
                Row {
                    Image(painter = painterResource(id = R.drawable.img), contentDescription ="" )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "@ Serviceteke",
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp)

                }
            }
            Spacer(modifier = Modifier.height(30.dp))

            Card (
                modifier = Modifier
                    .height(50.dp)
                    .width(400.dp),
                elevation = CardDefaults.cardElevation(20.dp),
                shape = CutCornerShape(11.dp)



            ){
                Row {
                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription ="" )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "@ 0738950368",
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp)

                }
                Spacer(modifier = Modifier.height(30.dp))
            }
            Spacer(modifier = Modifier.height(30.dp))
            Card (
                modifier = Modifier
                    .height(50.dp)
                    .width(400.dp),
                elevation = CardDefaults.cardElevation(20.dp),
                shape = CutCornerShape(11.dp)



            ){
                Row {
                    Image(painter = painterResource(id = R.drawable.img_2), contentDescription ="" )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "@ 0738950368",
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp)

                }
            }





        }



    }



}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    AboutScreen(rememberNavController())
}