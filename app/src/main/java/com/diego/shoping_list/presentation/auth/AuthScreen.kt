package com.diego.shoping_list.presentation.auth

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diego.shoping_list.compose.app_logo.AppLogo
import kotlinx.coroutines.launch

@Preview(name = "auth")
@Composable
fun AuthScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var visible by remember { mutableStateOf(false) }
    val emailBringIntoView = remember { BringIntoViewRequester() }
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .imePadding()
    ) {
        BackgroundWithGlows()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
                .padding(vertical = 120.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White.copy(alpha = 0.6f)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StaticText()

            OutlinedTextField(
                value = email,
                onValueChange = { value ->
                    email = value
                    emailError = when {
                        value.isBlank() -> null
                        !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches() ->
                            "Некорректный email"

                        else -> null
                    }
                },
                label = { Text("Email") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                isError = emailError != null,
                supportingText = emailError?.let { { Text(it) } },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFA370EE),
                    unfocusedBorderColor = Color.LightGray,
                    focusedLabelColor = Color(0xFFA370EE),
                    cursorColor = Color(0xFFA370EE),
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                ),
            )

            OutlinedTextField(
                value = password,
                onValueChange = { value ->
                    password = value
                },
                label = { Text("Password") },
                singleLine = true,
                visualTransformation = if (visible) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                isError = passwordError != null,
                supportingText = passwordError?.let { { Text(it) } },
                trailingIcon = {
                    IconButton(onClick = { visible = !visible }) {
                        Icon(
                            imageVector = if (visible) Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff,
                            contentDescription = if (visible) "Скрыть" else "Показать"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .onFocusChanged {state ->
                        if (state.isFocused) {
                            scope.launch {
                                emailBringIntoView.bringIntoView()
                            }
                        }
                    },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFA370EE),
                    unfocusedBorderColor = Color.LightGray,
                    focusedLabelColor = Color(0xFFA370EE),
                    cursorColor = Color(0xFFA370EE),
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                ),
            )
        }
    }
}

@Composable
fun BackgroundWithGlows() {
    val infinite = rememberInfiniteTransition()

    val shift1 by infinite.animateFloat(
        initialValue = -40f,
        targetValue = 40f,
        animationSpec = infiniteRepeatable(
            tween(3000, easing = LinearEasing),
            RepeatMode.Reverse
        )
    )
    val shift2 by infinite.animateFloat(
        initialValue = 30f,
        targetValue = -30f,
        animationSpec = infiniteRepeatable(
            tween(4000, easing = LinearEasing),
            RepeatMode.Reverse
        )
    )

    Box(Modifier.fillMaxSize()) {
        GlowCircle(
            color = MaterialTheme.colorScheme.inversePrimary,
            size = 600.dp,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = (-100).dp + shift1.dp, y = (-150).dp + shift1.dp)
        )
        GlowCircle(
            color = Color.Cyan,
            size = 600.dp,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = 100.dp + shift2.dp, y = 150.dp + shift2.dp)
        )
    }
}

@Composable
fun GlowCircle(color: Color, size: Dp, modifier: Modifier) {
    Box(
        modifier = modifier
            .size(size)
            .blur(200.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
            .background(color, CircleShape)
    )
}

@Composable
fun StaticText() {
    Image(
        imageVector = AppLogo(),
        contentDescription = AppLogo().name
    )
    Text(
        text = "Login",
        modifier = Modifier.padding(top = 12.dp),
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = "Enter your email and password to log in",
        modifier = Modifier.padding(top = 12.dp),
        color = Color.DarkGray,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = TextUnit.Unspecified
    )
}