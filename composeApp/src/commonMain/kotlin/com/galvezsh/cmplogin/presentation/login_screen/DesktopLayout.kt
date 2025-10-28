package com.galvezsh.cmplogin.presentation.login_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.cmplogin.presentation.shared.LoginButton
import com.galvezsh.cmplogin.presentation.shared.LoginCheckBox
import com.galvezsh.cmplogin.presentation.shared.LoginEmailField
import com.galvezsh.cmplogin.presentation.shared.LoginHeaderTexts
import com.galvezsh.cmplogin.presentation.shared.LoginPasswordField

/**
 * Desktop Layout - Two-column design
 * Left: Branding and welcome message
 * Right: Login form
 * Optimized for large screens (> 880dp)
 */
@Composable
fun DesktopLayout( viewModel: LoginViewModel, onPressedLoginButton: () -> Unit ) {

    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()
    val rememberMe by viewModel.rememberMe.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Row( modifier = Modifier.fillMaxSize() ) {
        // Left side - Branding
        Box(
            modifier = Modifier.weight( 1f ).fillMaxHeight().background(
                    // Gradient background (if you want, you can add a gradient here)
                    Color(0xFF1976D2)
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding( all = 48.dp )
            ) {
                // Large logo/icon
                Surface(
                    shape = CircleShape,
                    color = Color.White.copy( alpha = 0.2f ),
                    modifier = Modifier.size( size = 120.dp ),
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color.White,
                            modifier = Modifier.size( size = 100.dp ),
                        ) {}
                    }
                }

                Spacer(modifier = Modifier.height( height = 32.dp ))

                Text(
                    text = "Welcome Back",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height( height = 16.dp ))

                Text(
                    text = "Sign in to continue to your account",
                    fontSize = 18.sp,
                    color = Color.White.copy( alpha = 0.9f ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.widthIn( max = 400.dp )
                )
            }
        }

        // Right side - Login form
        Box(
            modifier = Modifier.weight( 1f ).fillMaxHeight().background( Color(0xFFF7F8FA) ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .widthIn ( max = 440.dp )
                    .padding( horizontal = 48.dp, vertical = 32.dp )
                    .verticalScroll( state = rememberScrollState() )
            ) {
                // LOGIN HEAD
                LoginHeaderTexts(
                    titleText = "Application name",
                    titleFontSize = 40.sp,
                    subtitleText = "Application description label",
                    subtitleFontSize = 18.sp
                )

                Spacer( modifier = Modifier.height( height = 48.dp ))

                // LOGIN BODY
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy( space = 16.dp )
                ) {
                    LoginEmailField(
                        label = "Email or username",
                        fontSize = 18.sp,
                        placeholder = "Insert your email or username",
                        value = username,
                        onValueChanged = viewModel::onUsernameChanged
                    )

                    Spacer( modifier = Modifier.height( height = 8.dp ))

                    LoginPasswordField(
                        label = "Password",
                        fontSize = 18.sp,
                        placeholder = "Insert your password",
                        value = password,
                        onValueChanged = viewModel::onPasswordChanged
                    )
                }

                LoginCheckBox(
                    text = "Remember me",
                    fontSize = 16.sp,
                    checked = rememberMe,
                    onCheckedChange = viewModel::onRememberMeChanged
                )

                LoginButton(
                    text = "Log In",
                    fontSize = 18.sp,
                    isEnabled = username.isNotEmpty() && password.isNotEmpty(),
                    isLoading = isLoading,
                    modifier = Modifier.fillMaxWidth().height( height = 56.dp ),
                    onClick = onPressedLoginButton
                )
            }
        }
    }
}