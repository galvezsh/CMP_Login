package com.galvezsh.cmplogin.presentation.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun EmailField(placeholder: String, value: String, onValueChanged: (String) -> Unit ) {
    OutlinedTextField(
        placeholder = { Text( placeholder ) },
        value = value,
        onValueChange = { onValueChanged( it ) },
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Email ),
        enabled = true,
        singleLine = true,
        leadingIcon = { Icon( Icons.Filled.Person, contentDescription = null ) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTextColor = Color(0xFF333333),
            unfocusedTextColor = Color(0xFF333333),
            focusedPlaceholderColor = Color(0xFFB0B0B0),
            unfocusedPlaceholderColor = Color(0xFFB0B0B0),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun PasswordField( placeholder: String, value: String, onValueChanged: (String) -> Unit ) {

    var showPassword by remember { mutableStateOf(false) }
    val icon = if ( showPassword ) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

    OutlinedTextField(
        placeholder = { Text( placeholder ) },
        value = value,
        onValueChange = { onValueChanged( it ) },
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Password ),
        enabled = true,
        singleLine = true,
        visualTransformation = if ( showPassword ) VisualTransformation.None else PasswordVisualTransformation(),
        leadingIcon = { Icon( Icons.Filled.Lock, contentDescription = null ) },
        trailingIcon = {
            IconButton( onClick = { showPassword = !showPassword } ) {
                Icon( imageVector = icon, contentDescription = null )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTextColor = Color(0xFF333333),
            unfocusedTextColor = Color(0xFF333333),
            focusedPlaceholderColor = Color(0xFFB0B0B0),
            unfocusedPlaceholderColor = Color(0xFFB0B0B0),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}