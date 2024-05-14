package com.example.evento.ui.theme.screens.tickets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.evento.navigation.ROUTE_FIND_EVENTS
import com.example.evento.navigation.ROUTE_HOME
import com.example.evento.navigation.ROUTE_HOST_EVENTS
import com.example.evento.navigation.ROUTE_TICKET_PAYMENT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketOrdering(navController: NavHostController) {

    var event by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        MediumTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                titleContentColor = MaterialTheme.colorScheme.background,
            ),
            title = {
                Text("Top app Bar")
            },
            navigationIcon = {
                IconButton(onClick = {}) {

                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Localized description"
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "Localized description"
                    )
                }
            },

            )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Order your ticket now",
            color = Color.White,
            fontFamily = FontFamily.Default,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = name, onValueChange = { name = it },
            label = { Text(text = "Enter your full name") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = event, onValueChange = { event = it },
            label = { Text(text = "Enter name of event") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(onClick = { navController.navigate(ROUTE_TICKET_PAYMENT)}) {
            Text(text = "OrderTicket", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(290.dp))
        BottomAppBar(
            actions = {
                IconButton(onClick = { ROUTE_HOME }) {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = "Home"
                    )
                }
                IconButton(onClick = { ROUTE_FIND_EVENTS }) {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Localized description",
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = "Localized description",
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.DateRange,
                        contentDescription = "Localized description",
                    )
                }

            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navController.navigate(ROUTE_HOST_EVENTS) },
                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                ) {
                    Icon(Icons.Filled.Add, "Localized description")
                }
            }
        )
    }
    Spacer(modifier = Modifier.height(10.dp))

}




@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TicketOrderingPreview() {
    TicketOrdering(rememberNavController())
}
