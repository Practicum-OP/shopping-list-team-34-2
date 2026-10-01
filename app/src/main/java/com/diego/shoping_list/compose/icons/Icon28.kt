package com.diego.shoping_list.compose.icons

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@SuppressLint("ComposableNaming")
@Composable
fun Icon28(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon28",
        defaultWidth = 48.dp,
        defaultHeight = 48.dp,
        viewportWidth = 48f,
        viewportHeight = 48f
    ).apply {
        group(
            clipPathData = PathData {
                moveTo(24f, 4f)
                lineTo(24f, 4f)
                arcTo(20f, 20f, 0f, isMoreThanHalf = false, isPositiveArc = true, 44f, 24f)
                lineTo(44f, 24f)
                arcTo(20f, 20f, 0f, isMoreThanHalf = false, isPositiveArc = true, 24f, 44f)
                lineTo(24f, 44f)
                arcTo(20f, 20f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4f, 24f)
                lineTo(4f, 24f)
                arcTo(20f, 20f, 0f, isMoreThanHalf = false, isPositiveArc = true, 24f, 4f)
                close()
            }
        ) {
            path(fill = SolidColor(Color(0xFFFEDDBD))) {
                moveTo(24f, 4f)
                lineTo(24f, 4f)
                arcTo(20f, 20f, 0f, isMoreThanHalf = false, isPositiveArc = true, 44f, 24f)
                lineTo(44f, 24f)
                arcTo(20f, 20f, 0f, isMoreThanHalf = false, isPositiveArc = true, 24f, 44f)
                lineTo(24f, 44f)
                arcTo(20f, 20f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4f, 24f)
                lineTo(4f, 24f)
                arcTo(20f, 20f, 0f, isMoreThanHalf = false, isPositiveArc = true, 24f, 4f)
                close()
            }
        }
        group(
            clipPathData = PathData {
                moveTo(12f, 12f)
                horizontalLineToRelative(24f)
                verticalLineToRelative(24f)
                horizontalLineToRelative(-24f)
                close()
            }
        ) {
            path(fill = SolidColor(Color(0xFF281805))) {
                moveTo(25f, 14f)
                verticalLineTo(22f)
                horizontalLineTo(33f)
                curveTo(33f, 17.58f, 29.42f, 14f, 25f, 14f)
                close()
                moveTo(27f, 20f)
                verticalLineTo(16.34f)
                curveTo(28.7f, 16.94f, 30.05f, 18.29f, 30.66f, 20f)
                horizontalLineTo(27f)
                close()
                moveTo(18.44f, 23f)
                lineTo(17.49f, 21f)
                horizontalLineTo(14f)
                verticalLineTo(23f)
                horizontalLineTo(16.22f)
                curveTo(16.22f, 23f, 18.11f, 27.07f, 18.34f, 27.42f)
                curveTo(17.24f, 28.01f, 16.5f, 29.17f, 16.5f, 30.5f)
                curveTo(16.5f, 32.43f, 18.07f, 34f, 20f, 34f)
                curveTo(21.76f, 34f, 23.22f, 32.7f, 23.46f, 31f)
                horizontalLineTo(25.54f)
                curveTo(25.78f, 32.7f, 27.24f, 34f, 29f, 34f)
                curveTo(30.93f, 34f, 32.5f, 32.43f, 32.5f, 30.5f)
                curveTo(32.5f, 29.46f, 32.04f, 28.53f, 31.32f, 27.89f)
                curveTo(32.37f, 26.54f, 33f, 24.84f, 33f, 23f)
                horizontalLineTo(18.44f)
                close()
                moveTo(20f, 32f)
                curveTo(19.17f, 32f, 18.5f, 31.33f, 18.5f, 30.5f)
                curveTo(18.5f, 29.67f, 19.17f, 29f, 20f, 29f)
                curveTo(20.83f, 29f, 21.5f, 29.67f, 21.5f, 30.5f)
                curveTo(21.5f, 31.33f, 20.83f, 32f, 20f, 32f)
                close()
                moveTo(29f, 32f)
                curveTo(28.17f, 32f, 27.5f, 31.33f, 27.5f, 30.5f)
                curveTo(27.5f, 29.67f, 28.17f, 29f, 29f, 29f)
                curveTo(29.83f, 29f, 30.5f, 29.67f, 30.5f, 30.5f)
                curveTo(30.5f, 31.33f, 29.83f, 32f, 29f, 32f)
                close()
                moveTo(29.74f, 26.66f)
                lineTo(29.45f, 27.03f)
                curveTo(29.31f, 27.01f, 29.15f, 27f, 29f, 27f)
                curveTo(27.61f, 27f, 26.4f, 27.82f, 25.84f, 29f)
                horizontalLineTo(23.16f)
                curveTo(22.66f, 27.96f, 21.66f, 27.2f, 20.48f, 27.03f)
                lineTo(20.04f, 26.36f)
                curveTo(19.94f, 26.19f, 19.7f, 25.67f, 19.37f, 25f)
                horizontalLineTo(30.66f)
                curveTo(30.45f, 25.59f, 30.14f, 26.15f, 29.74f, 26.66f)
                close()
            }
        }
    }.build()
}