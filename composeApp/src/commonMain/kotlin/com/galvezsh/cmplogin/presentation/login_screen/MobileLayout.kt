package com.galvezsh.cmplogin.presentation.login_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.cmplogin.presentation.shared.LoginButton
import com.galvezsh.cmplogin.presentation.shared.LoginCheckBox
import com.galvezsh.cmplogin.presentation.shared.LoginEmailField
import com.galvezsh.cmplogin.presentation.shared.LoginHeaderTexts
import com.galvezsh.cmplogin.presentation.shared.LoginPasswordField

/**
 * Mobile Layout - Single-column design
 * Optimized for smaller screens (< 840dp)
 */
@Composable
fun MobileLayout( viewModel: LoginViewModel, onPressedLoginButton: () -> Unit ) {

    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()
    val rememberMe by viewModel.rememberMe.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize().background( Color(0xFFF7F8FA) ),
        contentAlignment = Alignment.Center // Horizontal center alignment
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding( all = 16.dp )
                .verticalScroll( state = rememberScrollState() ),
        ) {

            // LOGIN HEAD
            Surface(
                shape = CircleShape,
                color = Color(0xFF1976D2),
                modifier = Modifier.size(84.dp),
            ) {}
            Spacer( modifier = Modifier.height( height = 32.dp ))
            LoginHeaderTexts(
                titleText = "Application name",
                titleFontSize = 32.sp,
                subtitleText = "Application description label",
                subtitleFontSize = 16.sp
            )
            Spacer( modifier = Modifier.height( height = 32.dp ))

            // LOGIN BODY
            Column (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy( space = 8.dp )
            ) {

                LoginEmailField(
                    label = "Email or username",
                    fontSize = 16.sp,
                    placeholder = "Insert your email or username",
                    value = username,
                    onValueChanged = viewModel::onUsernameChanged

                )
                Spacer( modifier = Modifier.height( height = 8.dp ))
                LoginPasswordField(
                    label = "Password",
                    fontSize = 16.sp,
                    placeholder = "Insert your password",
                    value = password,
                    onValueChanged = viewModel::onPasswordChanged
                )
            }

            LoginCheckBox(
                text = "Remember me",
                fontSize = 14.sp,
                checked = rememberMe,
                onCheckedChange = viewModel::onRememberMeChanged
            )

            LoginButton(
                text = "Log In",
                fontSize = 16.sp,
                isEnabled = username.isNotEmpty() && password.isNotEmpty(),
                isLoading = isLoading,
                modifier = Modifier.fillMaxWidth().height( height =  52.dp ),
                onClick = onPressedLoginButton
            )
        }
    }
}