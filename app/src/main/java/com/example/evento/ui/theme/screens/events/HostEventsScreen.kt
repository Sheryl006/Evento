package com.example.evento.ui.theme.screens.events

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.widget.Space
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.evento.data.AuthViewModel
import com.example.evento.navigation.ROUTE_EVENT_TYPE
import com.example.evento.navigation.ROUTE_HOME
import com.example.evento.navigation.ROUTE_USER_PROFILE
import java.lang.reflect.Modifier



@Composable
fun HostEvents(navController: NavHostController) {
    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Host An Event",
            color = Color.Black,
            fontFamily = FontFamily.Default,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))
        Text(
            text = "Fill in the form below ",
            color = Color.Black,
            fontFamily = FontFamily.Default,
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var pass by remember { mutableStateOf(TextFieldValue("")) }
        var phoneNumber by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text(text = "Enter Email") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(8.dp),
            label = { Text("Phone Number") },

//            keyboardType = KeyboardType.Phone
//            textStyle = MaterialTheme.typography.body
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
        OutlinedTextField(
            value = pass, onValueChange = { pass = it },
            label = { Text(text = "Enter Password") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))

        ElevatedButton(
            onClick = {

                navController.navigate(ROUTE_EVENT_TYPE) },
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
        )
        {
            Text(text = "Host Event")

        }


    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HostEventsScreen(){
    HostEvents(rememberNavController())
}