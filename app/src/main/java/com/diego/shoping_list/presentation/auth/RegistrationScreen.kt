package com.diego.shoping_list.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationScreen(
    viewModel: AuthViewModel,
    nameScreen: String = "Регистрация",
    userInstructions: String = "Создайте ваш аккаунт",
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
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        StaticHeader(nameScreen, userInstructions)

        val focusManager = LocalFocusManager.current

        EmailEditor(
            viewModel = viewModel,
            focusManager = focusManager,
            state = state,
        )

        PasswordEditor(
            viewModel = viewModel,
            state = state,
            singlePasswordMode = false,
        )

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
                .padding(top = 16.dp),
        ) {
            if (!state.isLoading) {
                Text("Зарегистрироваться")
            } else {
                CircularProgressIndicator(
                    color = Color(0xFFA370EE),
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp
                )
            }

        }

        Row(modifier = Modifier.padding(top = 16.dp)) {
            Text("Уже есть аккаунт? ")
            Text(
                text = "Войти",
                color = Color.Blue,
                modifier = Modifier.clickable { viewModel.setScreen(AuthScreens.LOGIN) },
            )
        }
    }
}