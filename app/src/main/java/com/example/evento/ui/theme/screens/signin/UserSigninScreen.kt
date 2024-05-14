package com.example.evento.ui.theme.screens.signin

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.evento.data.AuthViewModel
import com.example.evento.navigation.ROUTE_HOME
import com.example.evento.navigation.ROUTE_USER_LOGIN
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.TextButton
import androidx.compose.ui.text.font.FontWeight
import com.example.evento.navigation.ROUTE_USER_PROFILE
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import androidx.compose.runtime.mutableStateOf as mutableStateOf1

//user signs in in order to get an account
//@SuppressLint("RememberReturnType", "SuspiciousIndentation")
@Composable
fun UserSignin(navController: NavHostController, it: String.Companion){
    lateinit var auth: FirebaseAuth;
    auth = Firebase.auth
    var email by remember { mutableStateOf1(TextFieldValue("")) }
    var pass by remember { mutableStateOf1(TextFieldValue("")) }
    var confpass by remember { mutableStateOf1(TextFieldValue("")) }
    var name by remember { mutableStateOf1(TextFieldValue(""))  }


    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context= LocalContext.current


        Text(text = "Create an account ",
            color = Color.White,
            fontFamily = FontFamily.Default,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Sign in ",
            color = Color.White,
            fontFamily = FontFamily.Default,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value =name, onValueChange = {name=it},
            label = { Text(text = "Enter your full name") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(value =email , onValueChange = {email=it},
            label = { Text(text = "Enter Email") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(15.dp))


        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(value =pass , onValueChange = {pass=it},
            label = { Text(text = "Enter Password") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(value =confpass , onValueChange = {confpass=it},
            label = { Text(text = "Confirm Password") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))

        ElevatedButton(onClick = {
            navController.navigate(ROUTE_USER_PROFILE)
            val mysignin= AuthViewModel(navController, context)
            mysignin.signin(email.text.trim(), pass.text.trim(), confpass.text.trim())
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "SIGN IN")
        }

        Spacer(modifier = Modifier.height(10.dp))
        TextButton(
            onClick = {
                navController.navigate(ROUTE_USER_LOGIN)
            }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Already have an account? Click to login")
        }




    }
}




@Preview(showSystemUi = true, showBackground = true)
@Composable
fun UserSigninScreenPreview(){
    UserSignin(rememberNavController(), it = String)

}




