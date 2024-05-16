package net.ezra.ui.services



import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter

import coil.request.ImageRequest
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import java.util.UUID
import net.ezra.R
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_DISPLAY
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_POST
import net.ezra.ui.students.uploadImageToFirebaseStorage


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Postwork(navController: NavHostController) {
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),


        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(ROUTE_HOME){
                        popUpTo(ROUTE_POST){inclusive = true}
                    } }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription ="",
                            tint = Color.Black
                        )

                    }
                },
                title = {

                }, actions = {



                },
                colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xff75d6ee))
            )


        },
        {
            Spacer(modifier = Modifier
                .height(30.dp))
        },
        content = {

LazyColumn {
    item {
        Column(

            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
                .background(Color.White),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.service),
                contentDescription = "",
                modifier = Modifier
                    .size(80.dp))

            Text(text = "Post work")

            var photoUri: Uri? by remember { mutableStateOf(null) }
            val launcher =
                rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                    photoUri = uri
                }

            var studentName by rememberSaveable {
                mutableStateOf("")
            }

            var studentclass by rememberSaveable {
                mutableStateOf("")
            }

            var studentresidence by rememberSaveable {
                mutableStateOf("")
            }

            var studentid  by rememberSaveable {
                mutableStateOf("")
            }




            OutlinedTextField(
                value = studentName,
                onValueChange = { studentName = it },
                label = { Text(text = "Price") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
            )

            OutlinedTextField(
                value = studentclass,
                onValueChange = { studentclass = it },
                label = { Text(text = "Freelancer") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
            )



            OutlinedTextField(
                value = studentresidence,
                onValueChange = { studentresidence = it },
                label = { Text(text = "Contanct") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            )
            )

            OutlinedTextField(
                value = studentid,
                onValueChange = { studentid = it },
                label = { Text(text = "Work Description") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .size(200.dp),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )





            OutlinedButton(
                onClick = {
                    launcher.launch(
                        PickVisualMediaRequest(
                            //Here we request only photos. Change this to .ImageAndVideo if you want videos too.
                            //Or use .VideoOnly if you only want videos.
                            mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                        )
                    )
                }
            ) {
                Text("Select Profile Picture",)
            }


            if (photoUri != null) {
                //Use Coil to display the selected image
                val painter = rememberAsyncImagePainter(
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(data = photoUri)
                        .build()
                )

                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(150.dp)
                        .fillMaxWidth()
                        .border(1.dp, Color.Gray),
                    contentScale = ContentScale.Crop,

                    )
            }


            OutlinedButton(onClick = {
                photoUri?.let {
                    uploadImageToFirebaseStorage(
                        it,
                        studentName,
                        studentclass,
                        studentresidence,
                        studentid
                    )
                }

            }) {

                Text(text = "Post Work")


            }


        }

    }
}



    Text(
        modifier = Modifier
            .clickable {
                navController.navigate(ROUTE_DISPLAY) {
                    popUpTo(ROUTE_ADD_STUDENTS) { inclusive = true }
                }
            },
        text = "display ",
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onSurface
    )


})
}



fun uploadImageToFirebaseStorage(imageUri: Uri, studentName: String, studentclass: String, studentresidence: String, studentid: String) {
    val storageRef = FirebaseStorage.getInstance().reference
    val imageRef = storageRef.child("images/${UUID.randomUUID()}")

    val uploadTask = imageRef.putFile(imageUri)
    uploadTask.continueWithTask { task ->
        if (!task.isSuccessful) {
            task.exception?.let {
                throw it
            }
        }
        imageRef.downloadUrl
    }.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUri = task.result
            saveToFirestore(downloadUri.toString(), studentName , studentid, studentclass , studentresidence)
        } else {


        }
    }
}

fun saveToFirestore(
    imageUrl: String, studentName: String, studentid: String,
    studentresidence: String,
    studentclass: String) {
    val db = Firebase.firestore
    val imageInfo = hashMapOf(
        "imageurl" to imageUrl,
        "Price" to studentid,
        "Freelancer" to studentName,
        "Contact" to studentresidence,
        "Description" to studentclass



    )




    db.collection("Work")
        .add(imageInfo)
        .addOnSuccessListener {



        }
        .addOnFailureListener {
            // Handle error
        }
}







@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    Postwork(rememberNavController())
}

