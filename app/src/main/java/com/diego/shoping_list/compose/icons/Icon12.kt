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
fun Icon12(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon12",
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
                moveTo(26f, 15f)
                curveTo(26f, 13.9f, 26.9f, 13f, 28f, 13f)
                curveTo(29.1f, 13f, 30f, 13.9f, 30f, 15f)
                curveTo(30f, 16.1f, 29.1f, 17f, 28f, 17f)
                curveTo(26.9f, 17f, 26f, 16.1f, 26f, 15f)
                close()
                moveTo(33.4f, 32.09f)
                curveTo(33.17f, 32.04f, 32.94f, 32.11f, 32.76f, 32.26f)
                curveTo(32.07f, 32.86f, 31.12f, 33.14f, 30.16f, 32.93f)
                lineTo(29f, 32.69f)
                lineTo(28f, 26.5f)
                lineTo(24.68f, 23.83f)
                lineTo(26.48f, 20.94f)
                curveTo(27.63f, 22.78f, 29.68f, 24f, 32f, 24f)
                verticalLineTo(22f)
                curveTo(30.15f, 22f, 28.56f, 20.88f, 27.87f, 19.28f)
                lineTo(27.35f, 18.07f)
                curveTo(27.16f, 17.64f, 26.61f, 17f, 25.7f, 17f)
                horizontalLineTo(20f)
                lineTo(17.5f, 21f)
                lineTo(19.2f, 22.06f)
                lineTo(21.1f, 19f)
                horizontalLineTo(23.45f)
                lineTo(20.94f, 22.99f)
                curveTo(20.66f, 23.44f, 20.57f, 23.99f, 20.69f, 24.51f)
                lineTo(21.5f, 28f)
                lineTo(18f, 30.35f)
                lineTo(17.53f, 30.25f)
                curveTo(16.57f, 30.05f, 15.82f, 29.4f, 15.43f, 28.58f)
                curveTo(15.33f, 28.37f, 15.15f, 28.21f, 14.92f, 28.16f)
                curveTo(14.49f, 28.07f, 14.1f, 28.36f, 14.02f, 28.74f)
                curveTo(13.98f, 28.88f, 14f, 29.05f, 14.07f, 29.2f)
                curveTo(14.65f, 30.44f, 15.78f, 31.4f, 17.22f, 31.71f)
                lineTo(29.85f, 34.4f)
                curveTo(31.29f, 34.71f, 32.71f, 34.29f, 33.75f, 33.39f)
                curveTo(33.88f, 33.28f, 33.96f, 33.13f, 33.99f, 32.98f)
                curveTo(34.06f, 32.6f, 33.83f, 32.18f, 33.4f, 32.09f)
                close()
                moveTo(20.73f, 30.93f)
                lineTo(23.75f, 28.9f)
                lineTo(23.31f, 25.58f)
                lineTo(26.15f, 27.6f)
                lineTo(26.9f, 32.24f)
                lineTo(20.73f, 30.93f)
                close()
            }
        }
    }.build()
}