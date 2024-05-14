package com.example.evento.ui.theme.screens.tickets

import android.app.usage.UsageEvents
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.evento.ui.theme.Purple40


@Composable
fun TicketPayment(navController:NavHostController,event: UsageEvents.Event) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember {
        mutableStateOf("")
    }
    var ticketQuantity by remember { mutableStateOf(1)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val mContext = LocalContext.current

        Text(
            text = "Billing details",
            color = Color.White,
            fontFamily = FontFamily.Default,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold

        )
//        OutlinedTextField(value =name, onValueChange = {name=it},
//            label = { Text(text = "Enter your full name") },
//            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//
//            )
//
//        OutlinedTextField(value =email, onValueChange = {email=it},
//            label = { Text(text = "Enter your email") },
//            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//
//            )
//        Spacer(modifier = Modifier.height(15.dp))
//        OutlinedButton(onClick = { initiatePayment(event, phoneNumber, ticketQuantity) },
//            modifier = Modifier.align(Alignment.CenterHorizontally)) {
//            Text(text = "Purchase Tickets")
//        }
        OutlinedButton(onClick = {    val simToolKitLaunchIntent =
            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { mContext.startActivity(it) }
        },shape = RoundedCornerShape(3.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            colors = ButtonDefaults.buttonColors(Purple40)) {
            Text(text = "Pay now",) }

    }
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TicketPaymentPreview(){
    TicketPayment(rememberNavController(), event = UsageEvents.Event())
}