package com.kerry.prototype

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kerry.prototype.ui.theme.PrototypeTheme

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrototypeTheme {
                rest()

            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun rest() {
    Column(
        Modifier
            .background(Color.Red)
//              .fillMaxWidth()
//              .fillMaxHeight()
            .fillMaxSize(),
        
//        
        
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top




    ) {
        Row {
            Text(text = "World Chats")
            Spacer(modifier = Modifier
                .width(10.dp)
            )
            Text(text = "Battle Royale")
            Spacer(modifier = Modifier
                .width(10.dp)
            )
            Text(text = "Death match")
            Spacer(modifier = Modifier
                .height(45.dp)
            )
        }
        
        Text(text = "Android is easy to use" , color = Color.Blue)
        Text(text = "world is insane" ,
             modifier = Modifier
        .background(Color.Cyan),
            fontFamily =  FontFamily.SansSerif
            )
        val ee = LocalContext.current
        Button(onClick = {
            ee.startActivity(Intent(ee,MainActivity::class.java))
        },
            colors = ButtonDefaults.buttonColors(Color.Green),
            shape = RectangleShape
            ) {
            Text(text = "Home page")

        }
        val bb = LocalContext.current
        Button(onClick = {
            bb.startActivity(Intent(bb, theActivity::class.java))
        },
            shape = RoundedCornerShape(18.dp)
            ) {
            Text(text = "the page")

        }
        val tt = LocalContext.current
        Button(onClick = {  tt.startActivity(Intent(tt,imageActivity::class.java))
        }) {
            Text(text = "Images page")


        }
    }

}


