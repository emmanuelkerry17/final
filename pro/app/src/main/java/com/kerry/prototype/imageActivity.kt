package com.kerry.prototype

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kerry.prototype.ui.theme.PrototypeTheme

class imageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          image()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun image() {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        Text(text = "images")

        Image(painter = painterResource(id = R.drawable.images)
            , contentDescription = "ll",
            modifier = Modifier
                .size(354.dp))
//                colorFilter = ColorFilter.tint(Color.Red)\


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
        val ee = LocalContext.current
        Button(onClick = {
            ee.startActivity(Intent(ee, MainActivity::class.java))
        }) {
            Text(text = "Home page")


        }
        AsyncImage(
            model = "https://aniwatchtv.to/",
            contentDescription = null,
        )


    }
}




