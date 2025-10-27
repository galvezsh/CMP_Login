package com.galvezsh.cmplogin.presentation.login_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.galvezsh.cmplogin.presentation.shared.EmailField
import com.galvezsh.cmplogin.presentation.shared.PasswordField
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

class LoginScreen : Screen {

    @Preview
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = koinViewModel<LoginViewModel>()

        LoginScreenContent(
            viewModel = viewModel,
            onPressedLoginButton = {
                viewModel.onLogin()
//                navigator.push( item = HomeScreen() )
            }
        )
    }

    @Composable
    fun LoginScreenContent( viewModel: LoginViewModel, onPressedLoginButton: () -> Unit ) {

        val username by viewModel.username.collectAsState()
        val password by viewModel.password.collectAsState()
        val rememberMe by viewModel.rememberMe.collectAsState()

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

                LoginHeader()
                Spacer(modifier = Modifier.height(32.dp))
                LoginBody(
                    username = username,
                    onUsernameChanged = viewModel::onUsernameChanged,
                    password = password,
                    onPasswordChanged = viewModel::onPasswordChanged,
                    rememberMe = rememberMe,
                    onRememberMeChanged = viewModel::onRememberMeChanged
                )

                Button(
                    onClick = onPressedLoginButton,
                    modifier = Modifier.fillMaxWidth().height(52.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Log In", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}

@Composable
private fun LoginHeader() {
    Surface(
        shape = CircleShape,
        color = Color(0xFF1976D2),
        modifier = Modifier.size(84.dp),
    ) {}
    Spacer( modifier = Modifier.height( 32.dp ) )
    Text(
        text = "Application name",
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF1A1A1A)
    )
    Spacer( modifier = Modifier.height( 8.dp ) )
    Text(
        text = "Application description label",
        fontSize = 14.sp,
        color = Color(0xFF6E6E6E),
    )
}

@Composable
private fun LoginBody(
    username: String,
    onUsernameChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    rememberMe: Boolean,
    onRememberMeChanged: (Boolean) -> Unit
) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            text = "Email or username",
            fontSize = 16.sp,
            color = Color(0xFF1A1A1A),
            fontWeight = FontWeight.Bold
        )
        EmailField(
            placeholder = "Insert your email or username",
            value = username,
            onValueChanged = onUsernameChanged

        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Password",
            fontSize = 16.sp,
            color = Color(0xFF1A1A1A),
            fontWeight = FontWeight.Bold
        )
        PasswordField(
            placeholder = "Insert your password",
            value = password,
            onValueChanged = onPasswordChanged
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding( vertical = 32.dp ),
    ) {
        Checkbox(
            checked = rememberMe,
            onCheckedChange = onRememberMeChanged,
            modifier = Modifier.size(18.dp),
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF1976D2),
                uncheckedColor = Color(0xFFB0B0B0)
            )
        )
        Spacer( modifier = Modifier.padding( end = 8.dp ) )
        Text(
            text = "Remember me",
            fontSize = 14.sp,
            color = Color(0xFF333333)
        )
    }
}