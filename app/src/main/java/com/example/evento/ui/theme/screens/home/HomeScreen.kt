package com.example.evento.ui.theme.screens.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SmallTopAppBar
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.evento.R
import com.example.evento.navigation.ROUTE_FIND_EVENTS
import com.example.evento.navigation.ROUTE_HOME
import com.example.evento.navigation.ROUTE_HOST_EVENTS
import com.example.evento.navigation.ROUTE_TICKET_ORDERING
import com.example.evento.navigation.ROUTE_USER_PROFILE


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        var query by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }
//        val mContext = LocalContext.current

        SmallTopAppBar(
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
            }


        )
        SearchBar(query = query,
            onQueryChange = { query = it },
            onSearch = { newQuery ->
                println("Performing search on query: $newQuery")
            },
            active = active,
            onActiveChange = {
                active = it
            }) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Search for events",
                    color = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "Welcome ",
            fontSize = 40.sp,
            fontFamily = FontFamily.Default,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                val mContext = LocalContext.current
                Row(
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    //Column1

                    Column {
                        Card(
                            modifier = Modifier
                                .height(100.dp)
                                .width(250.dp)

                        ) {

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.orderingticket),
                                    contentDescription = "ticket",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "favorite",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(15.dp)
                                )

                            }

                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Event",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {

                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "star",
                                tint = Color.Green
                            )
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "star",
                                tint = Color.Green
                            )
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "star",
                                tint = Color.Green

                            )
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "star",
                                tint = Color.Green
                            )
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "star",
                                tint = Color.Green
                            )
                        }
                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "443 reviews",
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "From Ksh.100",
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.Green
                        )
                        Spacer(modifier = Modifier.height(5.dp))

                        Row {
                            OutlinedButton(onClick = {
                                val shareIntent = Intent(Intent.ACTION_SEND)
                                shareIntent.type = "text/plain"
                                shareIntent.putExtra(
                                    Intent.EXTRA_TEXT,
                                    "Check out this is a cool event"
                                )
                                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                            }) {
                                Text(text = "Call")

                            }
                            OutlinedButton(onClick = {
                                val shareIntent = Intent(Intent.ACTION_SEND)
                                shareIntent.type = "text/plain"
                                shareIntent.putExtra(
                                    Intent.EXTRA_EMAIL,
                                    arrayOf("faithsheryl8@gmail.com")
                                )
                                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "HOW CAN WE HELP")
                                shareIntent.putExtra(
                                    Intent.EXTRA_TEXT,
                                    "Hello, this is Sheryl and how may I help you?"
                                )
                                mContext.startActivity(shareIntent)
                            }) {
                                Text(text = "Email")
                            }
                            OutlinedButton(onClick = { navController.navigate(ROUTE_TICKET_ORDERING) }) {
                                Text(text = "Order Ticket")
                            }
                        }







                        Spacer(modifier = Modifier.height(250.dp))

                        BottomAppBar(
                            actions = {
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
                                    onClick = { navController.navigate(ROUTE_HOST_EVENTS) },
                                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                                ) {
                                    Icon(Icons.Filled.Add, "Localized description")
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}






@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}

