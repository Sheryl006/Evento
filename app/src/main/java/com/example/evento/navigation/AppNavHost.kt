package com.example.evento.navigation

import android.app.usage.UsageEvents
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evento.ui.theme.screens.events.EventType
import com.example.evento.ui.theme.screens.events.FindEventsScreen
import com.example.evento.ui.theme.screens.events.HostEvents
import com.example.evento.ui.theme.screens.events.UpdateEventsScreen
import com.example.evento.ui.theme.screens.events.ViewUploadsScreen

import com.example.evento.ui.theme.screens.home.HomeScreen
import com.example.evento.ui.theme.screens.login.UserLogin

import com.example.evento.ui.theme.screens.profile.UserProfile

import com.example.evento.ui.theme.screens.signin.UserSignin
import com.example.evento.ui.theme.screens.tickets.TicketOrdering
import com.example.evento.ui.theme.screens.tickets.TicketPayment


private val Any.arguments: Any
    get() { return TODO("Provide the return value")}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_USER_SIGNIN
) {
    NavHost(
        navController = navController,
        modifier = Modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_USER_SIGNIN) {
            UserSignin(navController, it = String)
        }
        composable(ROUTE_USER_LOGIN) {
            UserLogin(navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_FIND_EVENTS) {
            FindEventsScreen(navController, id = "")
        }
        composable(ROUTE_HOST_EVENTS) {
            HostEvents(navController)
        }
        composable(ROUTE_USER_PROFILE) {
            UserProfile(navController)
        }
        composable(ROUTE_TICKET_ORDERING) {
            TicketOrdering(navController)
        }
        composable(ROUTE_TICKET_PAYMENT) {
            TicketPayment(navController, event = UsageEvents.Event())
        }

        composable(ROUTE_EVENT_TYPE) {
            EventType(navController)
        }
        composable(ROUTE_EDIT_PROFILE) {

        }
        composable(ROUTE_VIEW_UPLOADS) {
            ViewUploadsScreen(navController)
        }
        composable(ROUTE_UPDATE_EVENT+"/{id}"){
            UpdateEventsScreen(navController,id = "")
        }
    }}

private fun Any.getString(s: String): String? {
    return TODO("Provide the return value")
}

