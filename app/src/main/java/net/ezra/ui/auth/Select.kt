package net.ezra.ui.auth


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DrawerValue
import androidx.compose.material.DropdownMenuItem
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.navigation.NavController
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
import net.ezra.navigation.ROUTE_SELECT
import net.ezra.navigation.ROUTE_SIGNFREE
import net.ezra.navigation.ROUTE_SIGNUP


@Composable
fun SelectScreen(navController: NavHostController) {
  Column(modifier = Modifier
      .fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
  ) {
      Column {
          Image(painter = painterResource(id = R.drawable.service),
              contentDescription = "",
              modifier = Modifier
                  .size(80.dp))
          Text(text = "Service Teke")
      }
      Spacer(modifier = Modifier
          .height(20.dp))

//      androidx.compose.material.
      Button(onClick = {navController.navigate(ROUTE_SIGNUP){
          popUpTo(ROUTE_SELECT) {inclusive = true}
      } },
          colors = ButtonDefaults.buttonColors(Color(0xff75d6ee))) {
          Image(painter = painterResource(id = R.drawable.getservice) ,
              contentDescription ="", modifier = Modifier
                  .size(40.dp))
          Text(text = "Client")


      }
      Spacer(modifier = Modifier
          .height(20.dp))

      Button(onClick = { navController.navigate(ROUTE_SIGNFREE){
          popUpTo(ROUTE_SELECT) {inclusive = true}
      } },
          colors = ButtonDefaults.buttonColors(Color(0xff75d6ee))) {
          Image(painter = painterResource(id = R.drawable.workers) ,
              contentDescription ="", modifier = Modifier
                  .size(40.dp))
          Text(text = "Freelancer")

      }

  }

}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    SelectScreen(rememberNavController())
}





    
