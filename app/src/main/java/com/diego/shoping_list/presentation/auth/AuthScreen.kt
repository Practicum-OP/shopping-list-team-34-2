package com.diego.shoping_list.presentation.auth

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diego.shoping_list.compose.app_logo.AppLogo
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthScreen(
    viewModel: AuthViewModel = koinViewModel(),
    onAuthSuccess: () -> Unit = {},
) {
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.effects.collect { effect ->
            when (effect) {
                is AuthEffect.ShowSnackbar -> snackbarHostState.showSnackbar(effect.message)
                is AuthEffect.NavigateToMain -> onAuthSuccess()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .imePadding(),
    ) {
        BackgroundWithGlows()

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 30.dp),
        )

        when (state.screen) {
            AuthScreens.LOGIN -> LoginScreen(state = state, onIntent = viewModel::onIntent)
            AuthScreens.REGISTRATION -> RegistrationScreen(state = state, onIntent = viewModel::onIntent)
        }
    }
}

@Composable
fun BackgroundWithGlows() {
    val infinite = rememberInfiniteTransition(label = "glow_transition")

    val shift1 by infinite.animateFloat(
        initialValue = -40f,
        targetValue = 40f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "shift1",
    )
    val shift2 by infinite.animateFloat(
        initialValue = 30f,
        targetValue = -30f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "shift2",
    )

    Box(Modifier.fillMaxSize()) {
        GlowCircle(
            color = MaterialTheme.colorScheme.inversePrimary,
            size = 600.dp,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = (-100).dp + shift1.dp, y = (-150).dp + shift1.dp),
        )
        GlowCircle(
            color = Color.Cyan,
            size = 600.dp,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = 100.dp + shift2.dp, y = 150.dp + shift2.dp),
        )
    }
}

@Composable
fun GlowCircle(color: Color, size: Dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(size)
            .blur(200.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
            .background(color, CircleShape),
    )
}

@Composable
fun StaticHeader(nameScreen: String, userInstructions: String) {
    val logo = AppLogo()
    Image(imageVector = logo, contentDescription = logo.name)
    Text(
        text = nameScreen,
        modifier = Modifier.padding(top = 12.dp),
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
    )
    Text(
        text = userInstructions,
        modifier = Modifier.padding(top = 12.dp),
        color = Color.DarkGray,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
    )
}