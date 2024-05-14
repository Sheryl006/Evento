package com.example.evento.ui.theme.screens.events

import android.content.Context
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.evento.data.EventViewModel
import com.example.evento.navigation.ROUTE_FIND_EVENTS
import com.example.evento.navigation.ROUTE_VIEW_UPLOADS


private val String.text: Any
    get() {return TODO("Provide the return value")}


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun EventType(navController: NavHostController ) {
    var name by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("")}
    var description by remember{ mutableStateOf("")}
    var price by remember{ mutableStateOf("")}
    Column( modifier = Modifier.verticalScroll(rememberScrollState())
        .fillMaxSize()
        .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current

        Text(
            text = "More information about the event ",
            color = Color.White,
            fontFamily = FontFamily.Default,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        var eventName by remember { mutableStateOf(TextFieldValue(name) )}
        var eventlocation by remember { mutableStateOf(TextFieldValue(location)) }
        var eventdescription by remember { mutableStateOf(TextFieldValue(description)) }
        var eventprice by remember { mutableStateOf(TextFieldValue(price)) }



        OutlinedTextField(
            value = eventName, onValueChange = { eventName = it },
            label = { Text(text = "Enter name of event") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = eventlocation, onValueChange = { eventlocation = it },
            label = { Text(text = "Enter location *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = eventdescription, onValueChange = { eventdescription = it },
            label = { Text(text = "Describe your event(make sure to state its purpose) *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = eventprice, onValueChange = { eventprice = it },
            label = { Text(text = "Enter price for one ticket *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
//        Button(onClick = {
//
//            val eventRepository = EventViewModel(navController, context)
//            eventRepository.saveEvent(
//                eventName.text.trim(), eventlocation.text.trim(),
//                eventdescription.text.trim(), eventprice.text
//            )
//            navController.navigate(ROUTE_FIND_EVENTS)
//
//
//        }) {
//
//            Text(text = "Save")
//        }
        Spacer(modifier = Modifier.height(10.dp))
        ImagePicker(
            Modifier,
            context,
            navController,
            eventName.text.trim(),
            eventlocation.text.trim() ,
            eventdescription.text.trim() ,
            eventprice.text

        )
    }
}



@Composable
fun ImagePicker(
    modifier: Modifier = Modifier,
    context: Context,
    navController: NavHostController,
    name: String,
    location: String,
    description: String,
    price: String

) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    text = "Select Image"
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = {
                    //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                    var eventRepository = EventViewModel(navController, context)
                    eventRepository.saveEventWithImage(
                        name,
                        location,
                        description,
                        price,
                        imageUri!!
                    )
                    navController.navigate(ROUTE_VIEW_UPLOADS)

                }) {
                    Text(text = "Upload")
                }
                Button(onClick = {
                    //-----------WRITE THE UPLOAD LOGIC HERE---------------//

                    navController.navigate(ROUTE_VIEW_UPLOADS)

                }) {
                    Text(text = "view uploads")
                }
            }
        }
    }
    fun Any.trim(): String {

        return TODO("Provide the return value")
    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun EventTypePreview() {
    EventType(rememberNavController())
}