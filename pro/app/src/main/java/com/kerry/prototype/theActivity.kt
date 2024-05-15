package com.kerry.prototype

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kerry.prototype.ui.theme.PrototypeTheme

class theActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            vision( )

        }
    }
}
@Preview(showBackground = true)
@Composable
fun vision() {
    Column(
        Modifier
            .background(Color.Green)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "THE")

        val ss = LocalContext.current
        Button(
            onClick = {
                ss.startActivity(Intent(ss, AboutActivity::class.java))
            },
            shape = CutCornerShape(percent = 40),
            border = BorderStroke(4.dp, Color.Magenta)
        ) {
            Text(text = "to next page")

        }
        val ee = LocalContext.current
        Button(onClick = {
            ee.startActivity(Intent(ee, MainActivity::class.java))
        }) {
            Text(text = "Home page")

        }
        val tt = LocalContext.current
        Button(onClick = {  tt.startActivity(Intent(tt,imageActivity::class.java))
        }) {
            Text(text = "Images page")
           

        }
        val vv= LocalContext.current
        val ff= AnnotatedString("click here for home")
        ClickableText(text = ff, onClick =  {
            vv.startActivity(Intent(vv, MainActivity::class.java))

        })



    }

}

