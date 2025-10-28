package com.galvezsh.cmplogin.presentation.shared

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jdk.jfr.Enabled

@Composable
fun LoginHeaderTexts( titleText: String, titleFontSize: TextUnit, subtitleText: String, subtitleFontSize: TextUnit ) {
    Text(
        text = titleText,
        fontSize = titleFontSize,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF1A1A1A)
    )
    Spacer( modifier = Modifier.height( 8.dp ) )
    Text(
        text = subtitleText,
        fontSize = subtitleFontSize,
        color = Color(0xFF6E6E6E),
    )
}

@Composable
fun LoginEmailField( label: String, placeholder: String, fontSize: TextUnit, value: String, onValueChanged: (String) -> Unit ) {
    Text(
        text = label,
        fontSize = fontSize,
        color = Color(0xFF1A1A1A),
        fontWeight = FontWeight.Bold
    )
    OutlinedTextField(
        placeholder = { Text( text = placeholder, fontSize = fontSize ) },
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
fun LoginPasswordField( label: String, placeholder: String, fontSize: TextUnit, value: String, onValueChanged: (String) -> Unit ) {

    var showPassword by remember { mutableStateOf(false) }
    val icon = if ( showPassword ) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
    val visualTransformation = if ( showPassword ) VisualTransformation.None else PasswordVisualTransformation()

    Text(
        text = label,
        fontSize = fontSize,
        color = Color(0xFF1A1A1A),
        fontWeight = FontWeight.Bold
    )
    OutlinedTextField(
        placeholder = { Text( text = placeholder, fontSize = fontSize ) },
        value = value,
        onValueChange = { onValueChanged( it ) },
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Password ),
        enabled = true,
        singleLine = true,
        visualTransformation = visualTransformation,
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

@Composable
fun LoginCheckBox( text: String, fontSize: TextUnit, checked: Boolean, onCheckedChange: (Boolean) -> Unit ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding( vertical = 32.dp ),
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.size( size = 18.dp ),
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF1976D2),
                uncheckedColor = Color(0xFFB0B0B0)
            )
        )
        Spacer( modifier = Modifier.padding( end = 8.dp ) )
        Text(
            text = text,
            fontSize = fontSize,
            color = Color(0xFF333333)
        )
    }
}

@Composable
fun LoginButton( text: String, fontSize: TextUnit, isEnabled: Boolean, isLoading: Boolean, modifier: Modifier, onClick: () -> Unit ) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        enabled = isEnabled && !isLoading,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1976D2),
            disabledContainerColor = Color(0xFF184A93)
        )
    ) {
        if ( isLoading ) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = Color.White,
                strokeWidth = 2.dp
            )
        } else {
            Text( text = text, fontSize = fontSize, color = if ( isEnabled ) Color.White else Color(0xFFB0B0B0) )
        }
    }
}