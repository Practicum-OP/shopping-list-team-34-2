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
fun Icon19(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon19",
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
                moveTo(18f, 31f)
                verticalLineTo(32f)
                curveTo(18f, 32.283f, 17.904f, 32.521f, 17.712f, 32.713f)
                curveTo(17.521f, 32.904f, 17.283f, 33f, 17f, 33f)
                horizontalLineTo(16f)
                curveTo(15.717f, 33f, 15.479f, 32.904f, 15.288f, 32.713f)
                curveTo(15.096f, 32.521f, 15f, 32.283f, 15f, 32f)
                verticalLineTo(24f)
                lineTo(17.1f, 18f)
                curveTo(17.2f, 17.7f, 17.379f, 17.458f, 17.638f, 17.275f)
                curveTo(17.896f, 17.092f, 18.183f, 17f, 18.5f, 17f)
                horizontalLineTo(29.5f)
                curveTo(29.817f, 17f, 30.104f, 17.092f, 30.362f, 17.275f)
                curveTo(30.621f, 17.458f, 30.8f, 17.7f, 30.9f, 18f)
                lineTo(33f, 24f)
                verticalLineTo(32f)
                curveTo(33f, 32.283f, 32.904f, 32.521f, 32.713f, 32.713f)
                curveTo(32.521f, 32.904f, 32.283f, 33f, 32f, 33f)
                horizontalLineTo(31f)
                curveTo(30.717f, 33f, 30.479f, 32.904f, 30.288f, 32.713f)
                curveTo(30.096f, 32.521f, 30f, 32.283f, 30f, 32f)
                verticalLineTo(31f)
                horizontalLineTo(18f)
                close()
                moveTo(17.8f, 22f)
                horizontalLineTo(30.2f)
                lineTo(29.15f, 19f)
                horizontalLineTo(18.85f)
                lineTo(17.8f, 22f)
                close()
                moveTo(19.5f, 28f)
                curveTo(19.917f, 28f, 20.271f, 27.854f, 20.563f, 27.563f)
                curveTo(20.854f, 27.271f, 21f, 26.917f, 21f, 26.5f)
                curveTo(21f, 26.083f, 20.854f, 25.729f, 20.563f, 25.438f)
                curveTo(20.271f, 25.146f, 19.917f, 25f, 19.5f, 25f)
                curveTo(19.083f, 25f, 18.729f, 25.146f, 18.438f, 25.438f)
                curveTo(18.146f, 25.729f, 18f, 26.083f, 18f, 26.5f)
                curveTo(18f, 26.917f, 18.146f, 27.271f, 18.438f, 27.563f)
                curveTo(18.729f, 27.854f, 19.083f, 28f, 19.5f, 28f)
                close()
                moveTo(28.5f, 28f)
                curveTo(28.917f, 28f, 29.271f, 27.854f, 29.563f, 27.563f)
                curveTo(29.854f, 27.271f, 30f, 26.917f, 30f, 26.5f)
                curveTo(30f, 26.083f, 29.854f, 25.729f, 29.563f, 25.438f)
                curveTo(29.271f, 25.146f, 28.917f, 25f, 28.5f, 25f)
                curveTo(28.083f, 25f, 27.729f, 25.146f, 27.438f, 25.438f)
                curveTo(27.146f, 25.729f, 27f, 26.083f, 27f, 26.5f)
                curveTo(27f, 26.917f, 27.146f, 27.271f, 27.438f, 27.563f)
                curveTo(27.729f, 27.854f, 28.083f, 28f, 28.5f, 28f)
                close()
                moveTo(17f, 29f)
                horizontalLineTo(31f)
                verticalLineTo(24f)
                horizontalLineTo(17f)
                verticalLineTo(29f)
                close()
            }
        }
    }.build()
}