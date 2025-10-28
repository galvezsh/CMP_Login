package com.galvezsh.cmplogin.presentation.login_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import cafe.adriel.voyager.core.screen.Screen
import com.galvezsh.cmplogin.presentation.shared.AdaptiveLayout
import com.galvezsh.cmplogin.presentation.shared.ScreenType
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

class LoginScreen: Screen {

    @Preview
    @Composable
    override fun Content() {
//        val navigator = LocalNavigator.currentOrThrow
        val viewModel = koinViewModel<LoginViewModel>()

        AdaptiveLayout { screenType ->
            when ( screenType ) {
                ScreenType.MOBILE -> MobileLayout( viewModel ) { viewModel.onLogin() }
                ScreenType.TABLET -> TabletLayout( viewModel ) { viewModel.onLogin() }
                ScreenType.DESKTOP -> DesktopLayout( viewModel ) { viewModel.onLogin() }
            }
        }
    }
}

