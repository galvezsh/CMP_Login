package com.galvezsh.cmplogin

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.galvezsh.cmplogin.di.commonModule
import com.galvezsh.cmplogin.presentation.login_screen.LoginScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication( application = { modules( listOf(
        commonModule,  // Common modules for all platforms
        platformModule // Special modules for each platform
    ) ) } ) {
        MaterialTheme {
            Navigator( screen = LoginScreen() ) { navigator ->
                SlideTransition( navigator )
            }
        }
    }
}