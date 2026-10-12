package com.diego.shoping_list.compose.icons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun SearchCloseIcon(): ImageVector = remember {
    ImageVector.Builder(
        name = "SearchCloseIcon",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        path(fill = SolidColor(Color.Black)) {
            moveTo(19f, 6.41f)
            lineTo(17.59f, 5f)
            lineTo(12f, 10.59f)
            lineTo(6.41f, 5f)
            lineTo(5f, 6.41f)
            lineTo(10.59f, 12f)
            lineTo(5f, 17.59f)
            lineTo(6.41f, 19f)
            lineTo(12f, 13.41f)
            lineTo(17.59f, 19f)
            lineTo(19f, 17.59f)
            lineTo(13.41f, 12f)
            close()
        }
    }.build()
}

@Composable
fun SearchBackIcon(): ImageVector = remember {
    ImageVector.Builder(
        name = "SearchBackIcon",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
        autoMirror = true
    ).apply {
        path(fill = SolidColor(Color.Black)) {
            moveTo(7.825f, 13f)
            lineTo(13.425f, 18.6f)
            lineTo(12f, 20f)
            lineTo(4f, 12f)
            lineTo(12f, 4f)
            lineTo(13.425f, 5.4f)
            lineTo(7.825f, 11f)
            horizontalLineTo(20f)
            verticalLineTo(13f)
            close()
        }
    }.build()
}
