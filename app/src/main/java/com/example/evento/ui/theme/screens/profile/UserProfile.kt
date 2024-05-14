package com.example.evento.ui.theme.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.evento.R
import com.example.evento.data.AuthViewModel
import com.example.evento.data.EventViewModel

import com.example.evento.navigation.ROUTE_FIND_EVENTS
import com.example.evento.navigation.ROUTE_HOME
import com.example.evento.navigation.ROUTE_HOST_EVENTS
import com.example.evento.navigation.ROUTE_USER_PROFILE

import androidx.compose.foundation.layout.Column as Column1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfile(navController: NavHostController){
    Column1 (modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {



        val image = painterResource(
            id =
            R.drawable.home
        )
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
                IconButton(onClick = { navController.navigate(ROUTE_USER_PROFILE) }) {
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
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))


        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            ElevatedButton(onClick = {
                navController.navigate(ROUTE_HOST_EVENTS)

            }) {
                Text(text = "HOST EVENT")
            }
            ElevatedButton(onClick = {
                navController.navigate(ROUTE_FIND_EVENTS)

            }) {
                Text(text = "FIND EVENTS")
            }
        }

        Spacer(modifier = Modifier.height(350.dp))
        BottomAppBar(actions = {
            IconButton(onClick = { navController.navigate(ROUTE_HOME) }) {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home"
                )
            }
            IconButton(onClick = { navController.navigate(ROUTE_FIND_EVENTS) }) {
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
                    onClick = { navController.navigate(ROUTE_HOST_EVENTS)  },
                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                ) {
                    Icon(Icons.Filled.Add, "Localized description")
                }
            })

    }}
//}
//@Composable
//fun UserItem(
//    name:String,
//    email:String,
//    navController = NavHostController,
//    authRepository = AuthViewModel
//){
//
//}







@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserProfilePreview(){
    UserProfile(rememberNavController())
}
