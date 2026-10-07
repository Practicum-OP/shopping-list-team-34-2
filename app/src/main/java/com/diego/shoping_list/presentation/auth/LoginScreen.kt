package com.diego.shoping_list.presentation.auth

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    onAuthResult: (Boolean) -> Unit = {},
    onRegistration: () -> Unit = {},
    nameScreen: String = "Вход",
    userInstructions: String = "Введите ваш email и пароль для входа",
) {
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.errorMessage) {
        Log.d("TAG", "LoginScreen: ${state.errorMessage}")
        state.errorMessage?.let { message ->
            snackbarHostState.showSnackbar(
                message = message,
                withDismissAction = true,
                duration = SnackbarDuration.Short,
            )
        }
    }

    LaunchedEffect(state.isLoggedIn) {
        if (state.isLoggedIn) onAuthResult(true)
    }

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

        val focusRequester = remember { FocusRequester() }
        val focusManager = LocalFocusManager.current

        EmailEditor(
            viewModel = viewModel,
            focusManager = focusManager,
            focusRequester = focusRequester,
            state = state,
        )

        PasswordEditor(
            viewModel = viewModel,
            state = state,
            singlePasswordMode = true,
        )

        var rememberMe by remember { mutableStateOf(false) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it },
                )
                Text("Запомнить меня")
            }

            Text(
                text = "Забыли пароль?",
                color = Color.Blue,
                modifier = Modifier
                    .clickable { /*пока ничего*/ }
                    .padding(4.dp),
            )
        }

        Button(
            onClick = {
                viewModel.login(state.email, state.password)
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp),
        ) {
            Text("Вход")
        }

        Row(modifier = Modifier.padding(top = 16.dp)) {
            Text("Нет аккаунта? ")
            Text(
                text = "Регистрация",
                color = Color.Blue,
                modifier = Modifier.clickable { onRegistration() },
            )
        }

        Box(modifier = Modifier.fillMaxSize()) {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.align(Alignment.BottomCenter),
            )
        }

    }
}