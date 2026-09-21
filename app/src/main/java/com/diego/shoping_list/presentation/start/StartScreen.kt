package com.diego.shoping_list.presentation.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diego.shoping_list.R
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun StartScreen(paddingValues: PaddingValues = PaddingValues.Zero,
                onFinished: () -> Unit
){    LaunchedEffect(Unit) {
    delay(2_000L.milliseconds) // 2 секунды
    onFinished()
}
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(top = 16.dp),
            painter = painterResource(id = R.drawable.ic_logo_shop_list),
            contentDescription = null
        )
        Image(
            modifier = Modifier.padding(top = 94.dp),
            painter = painterResource(id = R.drawable.ic_illustration_start_screen),
            contentDescription = null
        )
        Text(
            text = "Добро пожаловать в Список покупок!",
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight(500),
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 48.dp).padding(horizontal = 44.dp)
        )
        Text(
            text = "Создавайте списки, добавляйте товары, отмечайте, что уже куплено",
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp).padding(horizontal = 44.dp)
        )
    }
}