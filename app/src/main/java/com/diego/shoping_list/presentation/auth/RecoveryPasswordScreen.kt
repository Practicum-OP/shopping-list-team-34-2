package com.diego.shoping_list.presentation.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R

@Composable
fun RecoveryPasswordScreen(
    state: AuthState,
    onIntent: (AuthIntent) -> Unit,
    nameScreen: String = stringResource(R.string.recovery_password),
    userInstructions: String = stringResource(R.string.enter_email_used_during_registration)
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 120.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StaticHeader(nameScreen, userInstructions)

        EmailEditor(
            state = state,
            onIntent = onIntent,
            focusManager = focusManager
        )

        Button(
            onClick = {
                onIntent(AuthIntent.Submit)
            },
            enabled = state.isSubmitEnabled,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                Text(stringResource(R.string.reset_password))
            }
        }

        Text(
            text = stringResource(R.string.return_to_the_entrance),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable {
                    onIntent(
                        AuthIntent.SwitchScreen(AuthScreens.LOGIN)
                    )
                }
        )
    }
}