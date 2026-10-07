package com.diego.shoping_list.presentation.auth

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    onAuthResult: (Boolean) -> Unit = {},
    onRegistration: (Boolean) -> Unit = {},
    viewModel: AuthViewModel = koinViewModel(),
    nameScreen: String = "",
    userInstructions: String = ""
) {
    var password by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var visible by remember { mutableStateOf(false) }
    val emailBringIntoView = remember { BringIntoViewRequester() }
    val scope = rememberCoroutineScope()

    val state by viewModel.state.collectAsState()

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
        StaticHeader(nameScreen, userInstructions)

        val focusRequester = remember { FocusRequester() }
        val focusManager = LocalFocusManager.current

        EmailEditor(
            viewModel = viewModel,
            focusManager = focusManager,
            focusRequester = focusRequester,
            state = state
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
                .onFocusChanged { state ->
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

        Button(
            onClick = {
                viewModel.login(state.email, password)
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
        ) {
            Text("Log In")
        }

        Row(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Нет аккаунта ")
            Text(
                text = "Регистрация",
                color = Color.Blue,
                modifier = Modifier.clickable {
                    onRegistration(true)
                }
            )
        }

        LaunchedEffect(state) {
            Log.d(
                "TAG", "Result: ${state.result}\nisLoading: ${state.isLoading}" +
                        "\nisLogginIn: ${state.isLoggedIn}\n" +
                        "---${state.errorMessage}"
            )
            if (state.isLoggedIn) {
                onAuthResult(true)
            }
        }
    }
}