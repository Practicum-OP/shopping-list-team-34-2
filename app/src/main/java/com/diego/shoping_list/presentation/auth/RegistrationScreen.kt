package com.diego.shoping_list.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegistrationScreen(
    onAuthResult: (Boolean) -> Unit = {},
    onBackToLogin: () -> Unit = {},
    viewModel: AuthViewModel = koinViewModel(),
    nameScreen: String = "Registration",
    userInstructions: String = "Create an account to continue"
) {
    val state by viewModel.state.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

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
            focusRequester = focusRequester,
            focusManager = focusManager,
            state,
        )

        PasswordEditor(
            viewModel = viewModel,
            focusRequester = focusRequester,
            focusManager = focusManager,
            state,
        )

        // Кнопка регистрации
        Button(
            onClick = {
                keyboardController?.hide()
                if (state.passwordError == null && state.password.isNotBlank()) {
                    viewModel.register(state.email, state.password)
                }
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
        ) {
            Text("Sign Up")
        }

        // Ссылка назад на логин
        Row(modifier = Modifier.padding(top = 16.dp)) {
            Text("Already have an account? ")
            Text(
                text = "Log In",
                color = Color.Blue,
                modifier = Modifier.clickable { onBackToLogin() }
            )
        }

        // Реакция на результат регистрации
        LaunchedEffect(state.isLoggedIn) {
            if (state.isLoggedIn) {
                onAuthResult(true)
            }
        }

        //Здесь должен быть тоаст
        Text(state.errorMessage.toString())
    }
}