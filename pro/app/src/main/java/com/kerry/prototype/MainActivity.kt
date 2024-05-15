package com.kerry.prototype

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kerry.prototype.ui.theme.PrototypeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            home()

        }
    }
}
@Preview(showBackground = true)
@Composable
fun home() {
    
 Column(
     Modifier
         .background(Color.White)
         .fillMaxSize()
         .padding(20.dp),
     horizontalAlignment = Alignment.CenterHorizontally

     
 ) {
     Text(text = "This is the HOME screen")
     val ss = LocalContext.current
     Button(onClick = {
         ss.startActivity(Intent(ss, AboutActivity::class.java))
     },
         shape = CutCornerShape(percent = 40),
         border = BorderStroke(4.dp, Color.Magenta)
         ) {
         Text(text = "to next page")
         
     }
     val bb = LocalContext.current
     Button(onClick = {
         bb.startActivity(Intent(bb, theActivity::class.java))
     },
         shape = CircleShape
         ) {
         Text(text = "the page")

     }
     val tt = LocalContext.current
     Button(onClick = {tt.startActivity(Intent(tt,imageActivity::class.java))
     }) {
         Text(text = "Images")
         

     }
     val kl = LocalContext.current
     Button(onClick = {kl.startActivity(Intent(kl,inputActivity::class.java))
     }) {
         Text(text = "input")


     }
     val klt = LocalContext.current
     Button(onClick = {klt.startActivity(Intent(klt,importActivity::class.java))
     }) {
         Text(text = "import                                                             ")


     }
 }
}


