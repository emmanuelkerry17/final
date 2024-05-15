package com.kerry.prototype

import android.graphics.Outline
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kerry.prototype.ui.theme.PrototypeTheme

class inputActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         input()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun input() {
    Box(
        Modifier
            . fillMaxSize()
    ){
       androidx.compose.foundation.Image(painter = painterResource(id  = R.drawable.images) ,
           contentDescription = "",
           modifier = Modifier
               .fillMaxSize(),
           contentScale = ContentScale.Crop
       )


    }
    
    
    Column(
        Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.Start
        
    ) {

         var ee by remember {
             mutableStateOf(TextFieldValue(""))
         }
         OutlinedTextField(value = ee, onValueChange ={ee = it},
             label = { Text(text = "Gender")},
             textStyle = TextStyle(Color.White),
             leadingIcon = { Icon(imageVector = Icons.Default.Face, contentDescription ="" )},
             keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(

                unfocusedBorderColor = Color.Red,
                focusedBorderColor = Color.White,
                unfocusedLabelColor = Color.Red,
                focusedLabelColor = Color.White,
                cursorColor = Color.White,
                unfocusedLeadingIconColor = Color.White,
                focusedLeadingIconColor = Color.Red
            )

             )
        
         Spacer(modifier = Modifier
             .height(40.dp))


        var rr by remember {
            mutableStateOf(TextFieldValue(""))
        }
        OutlinedTextField(value = rr, onValueChange ={rr = it},
            label = { Text(text = "Email")},
            textStyle = TextStyle(Color.White),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription ="" )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Red,
                focusedBorderColor = Color.White,
                unfocusedLabelColor = Color.Red,
                focusedLabelColor = Color.White,
                cursorColor = Color.White,
                unfocusedLeadingIconColor = Color.White,
                focusedLeadingIconColor = Color.Red
            )


        )
        Spacer(modifier = Modifier
            .height(40.dp))
        
        var ff by remember {
            mutableStateOf(TextFieldValue(""))
        }
        OutlinedTextField(value = ff , onValueChange = {ff=it },
            label = { Text(text = "Password")},
            textStyle = TextStyle(Color.White),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription ="" )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Red,
                focusedBorderColor = Color.White,
                unfocusedLabelColor = Color.Red,
                focusedLabelColor = Color.White,
                cursorColor = Color.White,
                unfocusedLeadingIconColor = Color.White,
                focusedLeadingIconColor = Color.Red




            )
            )
        Spacer(modifier = Modifier
            .height(40.dp))


        var bb by remember {
            mutableStateOf(TextFieldValue(""))
        }
        OutlinedTextField(value = bb , onValueChange = {bb=it },
            label = { Text(text = "Phone Number")},
            textStyle = TextStyle(Color.White),
            leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription ="" )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Red,
                focusedBorderColor = Color.White,
                unfocusedLabelColor = Color.Red,
                focusedLabelColor = Color.White,
                cursorColor = Color.White,
                unfocusedLeadingIconColor = Color.White,
                focusedLeadingIconColor = Color.Red


            )
        )
         
        
        
    }
  
}
