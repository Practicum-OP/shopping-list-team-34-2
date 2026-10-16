package com.diego.shoping_list.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun AppBarIcon(
    @DrawableRes iconResId: Int,
    contentDescription: String,
) {
    Icon(
        painter = painterResource(iconResId),
        contentDescription = contentDescription,
    )
}
