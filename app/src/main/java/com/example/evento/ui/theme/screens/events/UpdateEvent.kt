package com.example.evento.ui.theme.screens.events

import android.provider.CalendarContract.Events
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.evento.data.EventViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.events.Event


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateEventsScreen(navController: NavHostController, id: String) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        var name by remember { mutableStateOf("") }
        var location by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var price by remember{mutableStateOf("")}

        var currentDataRef = FirebaseDatabase.getInstance().getReference()
            .child("Events/$id")
        currentDataRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var event = snapshot.getValue(com.example.evento.models.Events::class.java)
                name = event!!.name
                location = event!!.location
                description= event!!.description
                price = event!!.price
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        Text(
            text = "Add event",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )
        var eventName by remember{ mutableStateOf(TextFieldValue(name))}
        var eventlocation by remember{ mutableStateOf(TextFieldValue(location))}
        var eventdescription by remember { mutableStateOf(TextFieldValue(description))}
        var eventprice by remember{ mutableStateOf(TextFieldValue(price))}
        OutlinedTextField(
            value = eventName, onValueChange = { eventName = it },
            label = { Text(text = "Enter name of event*") },
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
            label = { Text(text = "Enter price for one ticket *" ) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            //-----------WRITE THE UPDATE LOGIC HERE---------------//
            var eventRepository = EventViewModel(navController, context)
            eventRepository.updateEvent(
                eventName.text.trim(), eventlocation.text.trim(),
                eventdescription.text.trim(), eventprice.text.trim(),id)


        }) {
            Text(text = "Update")
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun UpdateEventsScreenPreview() {

    UpdateEventsScreen(rememberNavController(), id ="" )
}



