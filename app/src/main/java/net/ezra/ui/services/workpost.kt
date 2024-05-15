package net.ezra.ui.services



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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import net.ezra.ui.students.uploadImageToFirebaseStorage


@Composable
fun Postwork(navController: NavHostController) {


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

            var Location by rememberSaveable {
                mutableStateOf("")
            }

            var Freelancer by rememberSaveable {
                mutableStateOf("")
            }

            var Description by rememberSaveable {
                mutableStateOf("")
            }

            var Contact  by rememberSaveable {
                mutableStateOf("")
            }




            OutlinedTextField(
                value = Location,
                onValueChange = { Location = it },
                label = { Text(text = "Location") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = Freelancer,
                onValueChange = { Freelancer = it },
                label = { Text(text = "Freelancer") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )



            OutlinedTextField(
                value = Contact,
                onValueChange = { Contact = it },
                label = { Text(text = "Contanct") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = Description,
                onValueChange = { Description = it },
                label = { Text(text = "Work Description") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .size(100.dp)
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
                        Location,
                        Freelancer,
                        Contact,
                        Description
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


}



fun uploadImageToFirebaseStorage(imageUri: Uri, Location: String, Freelancer: String, Contact:Int, Description:String) {
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
            saveToFirestore(downloadUri.toString(), Location , Freelancer, Contact , Description)
        } else {


        }
    }
}

fun saveToFirestore(
    imageUrl: String, Location: String, Freelancer: String,
    Contact: Int,
    Description: String) {
    val db = Firebase.firestore
    val imageInfo = hashMapOf(
        "imageurl" to imageUrl,
        "Location" to Location,
        "Freelancer" to Freelancer,
        "Contact" to Contact,
        "Description" to Description



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

