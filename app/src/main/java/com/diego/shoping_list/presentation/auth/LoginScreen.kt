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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R

@Composable
fun LoginScreen(
    state: AuthState,
    onIntent: (AuthIntent) -> Unit,
    nameScreen: String = stringResource(R.string.enter),
    userInstructions: String = stringResource(R.string.enter_your_email_and_password_for_login),
) {

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

        EmailEditor(state = state, onIntent = onIntent, focusManager = focusManager)

        PasswordEditor(
            state = state,
            onIntent = onIntent,
            singlePasswordMode = true,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = state.rememberMe,
                    onCheckedChange = {
                        onIntent(AuthIntent.RememberMeChanged(it))
                    },
                )
                Text(stringResource(R.string.remember_me))
            }

            Text(
                text = stringResource(R.string.forgot_your_password),
                color = Color.Blue,
                modifier = Modifier
                    .clickable {
                        onIntent(AuthIntent.SwitchScreen(AuthScreens.RECOVERY_PASSWORD))
                    }
                    .padding(4.dp),
            )
        }

        Button(
            onClick = { onIntent(AuthIntent.Submit) },
            enabled = state.isSubmitEnabled
        ) {
            if (!state.isLoading) Text(stringResource(R.string.enter))
            else CircularProgressIndicator()
        }

        Row(modifier = Modifier.padding(top = 16.dp)) {
            Text(stringResource(R.string.do_not_have_an_account))
            Text(
                text = stringResource(R.string.registration),
                color = Color.Blue,
                modifier = Modifier.clickable {
                    onIntent(AuthIntent.SwitchScreen(AuthScreens.REGISTRATION))
                }
                    .padding(start = 4.dp),
            )
        }
    }
}