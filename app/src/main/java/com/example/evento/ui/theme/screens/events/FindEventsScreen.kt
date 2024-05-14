package com.example.evento.ui.theme.screens.events

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.evento.data.EventViewModel
import com.example.evento.models.Events
import com.example.evento.navigation.ROUTE_FIND_EVENTS
import com.example.evento.navigation.ROUTE_HOME
import com.example.evento.navigation.ROUTE_HOST_EVENTS
import com.example.evento.navigation.ROUTE_TICKET_PAYMENT
import com.example.evento.navigation.ROUTE_UPDATE_EVENT
import com.example.evento.navigation.ROUTE_USER_PROFILE



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindEventsScreen(navController: NavHostController,id: String){

    Column {
        val context = LocalContext.current
        val eventRepository = EventViewModel(navController, context)
        val emptyEventState = remember{ mutableStateOf(Events("","","","",""))}
        val emptyEventsListState = remember{ mutableListOf<Events> ()}
//        var currentDataRef = FirebaseDatabase.getInstance().getReference()
//            .child("Events/$id")
        val events = eventRepository.viewEvent(emptyEventState, emptyEventsListState)
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
                IconButton(onClick = {navController.navigate(ROUTE_USER_PROFILE) }) {
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
            }
        )
        Text(text = "Events you might like",
            fontSize = 15.sp,
            fontFamily = FontFamily.Default,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))

        Box(modifier = Modifier.fillMaxWidth()){
            LazyColumn {
                items(events){
                    EventItem(
                        name = it.name,
                        location = it.location,
                        description = it.description,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        eventRepository = eventRepository

                    )




                }
            }
        }
    }



    Spacer(modifier = Modifier.height(100.dp))
    BottomAppBar(
        actions = {
            IconButton(onClick = { navController.navigate(ROUTE_HOME) }) {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home"
                )
            }
            IconButton(onClick = {navController.navigate(ROUTE_FIND_EVENTS)}) {
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

@Composable
fun EventItem(
    name: String,
    location: String,
    description: String,
    price: String,
    id:String,
    navController: NavHostController,
    eventRepository: EventViewModel,

    ) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = location)
        Text(text = description)
        Text(text = price)
        Button(onClick = { navController.navigate(ROUTE_TICKET_PAYMENT) }) {
            Text(text = "Order ticket")
        }
        Button(onClick = {
            eventRepository.deleteEvents(id)
        }) {
            Text(text = "Delete Event")
        }
        Button(onClick = {
            navController.navigate("$ROUTE_UPDATE_EVENT/$id")
        }) {
            Text(text = "Update")
        }
    }
}





@Composable
fun FindEventsScreenpreview(){
    FindEventsScreen(rememberNavController(),id = "")
}