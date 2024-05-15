package com.kerry.prototype

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kerry.prototype.ui.theme.PrototypeTheme

class assignmentActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrototypeTheme {
                assignment()

            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun assignment() {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    )

    {
        item {
            Column(Modifier
                .padding(30.dp)) {
                Row (

                    horizontalArrangement = Arrangement.Center
                ){
                    Icon(imageVector = Icons.Default.Menu , contentDescription = "",
                        Modifier
                            .background(Color.White),
                        Color.DarkGray
                            )
                    Spacer(modifier = Modifier
                        .width(60.dp))


                   Column {
                       Text(text = "Current Location")
                       Spacer(modifier = Modifier
                           .width(60.dp))
                       Row {
                           Icon(imageVector = Icons.Default.LocationOn , contentDescription = "",
                               Modifier
                                   .background(Color.LightGray),
                               Color.Blue
                           )
                           Text(text = "Denpasar, Bali")
                           Spacer(modifier = Modifier
                               .width(60.dp))

                       }



                   }

                    Image(painter = painterResource(id = R.drawable.images)
                        , contentDescription = "ll",
                        modifier = Modifier
                            .size(45.dp))


                }

                
                
            }
            Column(
                Modifier
                    .padding(30.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row {
                    val tt = LocalContext.current
                    Button(onClick = {  tt.startActivity(Intent(tt,imageActivity::class.java, ))
                    },
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Image(painter = painterResource(id = R.drawable.hotel) , contentDescription = "",
                            modifier = Modifier
                                .size(30.dp))

                        Text(text = "Hotels", color = Color.Black)}
                    Spacer(modifier =
                    Modifier
                        .width(50.dp))


                        val ttf = LocalContext.current
                        Button(onClick = {  ttf.startActivity(Intent(ttf,imageActivity::class.java, ))
                        },
                            colors = ButtonDefaults.buttonColors(Color.White)
                        ) {
                            Image(painter = painterResource(id = R.drawable.holiday) , contentDescription = "",
                                modifier = Modifier
                                    .size(30.dp))


                            Text(text = "Holiday", color = Color.Black)

                        }



                }
                Row {
                    val xs = LocalContext.current
                    Button(onClick = {  xs.startActivity(Intent(xs,imageActivity::class.java))
                    },
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Image(painter = painterResource(id = R.drawable.taxi) , contentDescription = "",
                            modifier = Modifier
                                .size(30.dp))




                        Text(text = "Taxi", color = Color.Black)
                    }
                    Spacer(modifier =
                    Modifier
                        .width(90.dp))

                    val xsd = LocalContext.current
                    Button(onClick = {  xsd.startActivity(Intent(xsd,imageActivity::class.java))
                    },
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Image(painter = painterResource(id = R.drawable.plane) , contentDescription = "",
                            modifier = Modifier
                                .size(30.dp))




                        Text(text = "Ticket", color = Color.Black)
                    }


                }
                Row {
                    val xsf = LocalContext.current
                    Button(onClick = {  xsf.startActivity(Intent(xsf,imageActivity::class.java))
                    },
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Image(painter = painterResource(id = R.drawable.plane) , contentDescription = "",
                            modifier = Modifier
                                .size(30.dp))




                        Text(text = "Airplane", color = Color.Black)
                    }
                    Spacer(modifier =
                        Modifier
                            .width(60.dp))


                    val xsw = LocalContext.current
                    Button(onClick = {  xsw.startActivity(Intent(xsw,imageActivity::class.java))
                    },
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Image(painter = painterResource(id = R.drawable.boat) , contentDescription = "",
                            modifier = Modifier
                                .size(30.dp))



                        Text(text = "Harbour", color = Color.Black)
                    }

                }

            }
            Column {
                Row {
                    Text(text = "Popular in town",
                        modifier = Modifier
                            )
                    Text(text = "View all")
                }
            }


        }
    }

}



