package com.example.leadminttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.leadminttask.screens.CashJoyScreen
import com.example.leadminttask.screens.MainReferScreen
import com.example.leadminttask.ui.theme.LeadMintTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeadMintTaskTheme {
                Column {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "cashJoyScreen") {
        composable("cashJoyScreen") { CashJoyScreen(navController) }
        composable("referEarnScreen") { MainReferScreen() }
    }
}


