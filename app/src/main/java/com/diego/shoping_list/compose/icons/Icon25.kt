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
fun Icon25(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon25",
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
                moveTo(18.8f, 32f)
                curveTo(18.3f, 32f, 17.875f, 31.825f, 17.525f, 31.475f)
                curveTo(17.175f, 31.125f, 17f, 30.7f, 17f, 30.2f)
                curveTo(17f, 29.85f, 17.1f, 29.521f, 17.3f, 29.212f)
                curveTo(17.5f, 28.904f, 17.767f, 28.683f, 18.1f, 28.55f)
                lineTo(22f, 27f)
                verticalLineTo(24.75f)
                curveTo(21.1f, 25.8f, 20.054f, 26.604f, 18.862f, 27.163f)
                curveTo(17.671f, 27.721f, 16.383f, 28f, 15f, 28f)
                verticalLineTo(26f)
                curveTo(16.133f, 26f, 17.163f, 25.767f, 18.087f, 25.3f)
                curveTo(19.013f, 24.833f, 19.85f, 24.167f, 20.6f, 23.3f)
                lineTo(21.95f, 21.7f)
                curveTo(22.15f, 21.467f, 22.383f, 21.292f, 22.65f, 21.175f)
                curveTo(22.917f, 21.058f, 23.2f, 21f, 23.5f, 21f)
                horizontalLineTo(24.5f)
                curveTo(24.8f, 21f, 25.083f, 21.058f, 25.35f, 21.175f)
                curveTo(25.617f, 21.292f, 25.85f, 21.467f, 26.05f, 21.7f)
                lineTo(27.4f, 23.3f)
                curveTo(28.15f, 24.167f, 28.987f, 24.833f, 29.913f, 25.3f)
                curveTo(30.837f, 25.767f, 31.867f, 26f, 33f, 26f)
                verticalLineTo(28f)
                curveTo(31.617f, 28f, 30.329f, 27.721f, 29.138f, 27.163f)
                curveTo(27.946f, 26.604f, 26.9f, 25.8f, 26f, 24.75f)
                verticalLineTo(27f)
                lineTo(29.9f, 28.55f)
                curveTo(30.233f, 28.683f, 30.5f, 28.904f, 30.7f, 29.212f)
                curveTo(30.9f, 29.521f, 31f, 29.85f, 31f, 30.2f)
                curveTo(31f, 30.7f, 30.825f, 31.125f, 30.475f, 31.475f)
                curveTo(30.125f, 31.825f, 29.7f, 32f, 29.2f, 32f)
                horizontalLineTo(22f)
                verticalLineTo(31.5f)
                curveTo(22f, 31.067f, 22.142f, 30.708f, 22.425f, 30.425f)
                curveTo(22.708f, 30.142f, 23.067f, 30f, 23.5f, 30f)
                horizontalLineTo(26.5f)
                curveTo(26.65f, 30f, 26.771f, 29.954f, 26.862f, 29.862f)
                curveTo(26.954f, 29.771f, 27f, 29.65f, 27f, 29.5f)
                curveTo(27f, 29.35f, 26.954f, 29.229f, 26.862f, 29.138f)
                curveTo(26.771f, 29.046f, 26.65f, 29f, 26.5f, 29f)
                horizontalLineTo(23.5f)
                curveTo(22.8f, 29f, 22.208f, 29.242f, 21.725f, 29.725f)
                curveTo(21.242f, 30.208f, 21f, 30.8f, 21f, 31.5f)
                verticalLineTo(32f)
                horizontalLineTo(18.8f)
                close()
                moveTo(24f, 20f)
                curveTo(23.45f, 20f, 22.979f, 19.804f, 22.587f, 19.413f)
                curveTo(22.196f, 19.021f, 22f, 18.55f, 22f, 18f)
                curveTo(22f, 17.45f, 22.196f, 16.979f, 22.587f, 16.587f)
                curveTo(22.979f, 16.196f, 23.45f, 16f, 24f, 16f)
                curveTo(24.55f, 16f, 25.021f, 16.196f, 25.413f, 16.587f)
                curveTo(25.804f, 16.979f, 26f, 17.45f, 26f, 18f)
                curveTo(26f, 18.55f, 25.804f, 19.021f, 25.413f, 19.413f)
                curveTo(25.021f, 19.804f, 24.55f, 20f, 24f, 20f)
                close()
            }
        }
    }.build()
}