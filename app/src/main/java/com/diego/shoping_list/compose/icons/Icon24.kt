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
fun Icon24(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon24",
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
                moveTo(18.5f, 28f)
                curveTo(19.283f, 28f, 20.046f, 28.087f, 20.788f, 28.263f)
                curveTo(21.529f, 28.438f, 22.267f, 28.7f, 23f, 29.05f)
                verticalLineTo(19.2f)
                curveTo(22.317f, 18.8f, 21.592f, 18.5f, 20.825f, 18.3f)
                curveTo(20.058f, 18.1f, 19.283f, 18f, 18.5f, 18f)
                curveTo(17.9f, 18f, 17.304f, 18.058f, 16.712f, 18.175f)
                curveTo(16.121f, 18.292f, 15.55f, 18.467f, 15f, 18.7f)
                verticalLineTo(28.6f)
                curveTo(15.583f, 28.4f, 16.163f, 28.25f, 16.737f, 28.15f)
                curveTo(17.313f, 28.05f, 17.9f, 28f, 18.5f, 28f)
                close()
                moveTo(25f, 29.05f)
                curveTo(25.733f, 28.7f, 26.471f, 28.438f, 27.212f, 28.263f)
                curveTo(27.954f, 28.087f, 28.717f, 28f, 29.5f, 28f)
                curveTo(30.1f, 28f, 30.688f, 28.05f, 31.263f, 28.15f)
                curveTo(31.837f, 28.25f, 32.417f, 28.4f, 33f, 28.6f)
                verticalLineTo(18.7f)
                curveTo(32.45f, 18.467f, 31.879f, 18.292f, 31.288f, 18.175f)
                curveTo(30.696f, 18.058f, 30.1f, 18f, 29.5f, 18f)
                curveTo(28.717f, 18f, 27.942f, 18.1f, 27.175f, 18.3f)
                curveTo(26.408f, 18.5f, 25.683f, 18.8f, 25f, 19.2f)
                verticalLineTo(29.05f)
                close()
                moveTo(24f, 32f)
                curveTo(23.2f, 31.367f, 22.333f, 30.875f, 21.4f, 30.525f)
                curveTo(20.467f, 30.175f, 19.5f, 30f, 18.5f, 30f)
                curveTo(17.8f, 30f, 17.112f, 30.092f, 16.438f, 30.275f)
                curveTo(15.762f, 30.458f, 15.117f, 30.717f, 14.5f, 31.05f)
                curveTo(14.15f, 31.233f, 13.813f, 31.225f, 13.488f, 31.025f)
                curveTo(13.163f, 30.825f, 13f, 30.533f, 13f, 30.15f)
                verticalLineTo(18.1f)
                curveTo(13f, 17.917f, 13.046f, 17.742f, 13.137f, 17.575f)
                curveTo(13.229f, 17.408f, 13.367f, 17.283f, 13.55f, 17.2f)
                curveTo(14.317f, 16.8f, 15.117f, 16.5f, 15.95f, 16.3f)
                curveTo(16.783f, 16.1f, 17.633f, 16f, 18.5f, 16f)
                curveTo(19.467f, 16f, 20.413f, 16.125f, 21.337f, 16.375f)
                curveTo(22.263f, 16.625f, 23.15f, 17f, 24f, 17.5f)
                curveTo(24.85f, 17f, 25.737f, 16.625f, 26.663f, 16.375f)
                curveTo(27.587f, 16.125f, 28.533f, 16f, 29.5f, 16f)
                curveTo(30.367f, 16f, 31.217f, 16.1f, 32.05f, 16.3f)
                curveTo(32.883f, 16.5f, 33.683f, 16.8f, 34.45f, 17.2f)
                curveTo(34.633f, 17.283f, 34.771f, 17.408f, 34.862f, 17.575f)
                curveTo(34.954f, 17.742f, 35f, 17.917f, 35f, 18.1f)
                verticalLineTo(30.15f)
                curveTo(35f, 30.533f, 34.838f, 30.825f, 34.513f, 31.025f)
                curveTo(34.188f, 31.225f, 33.85f, 31.233f, 33.5f, 31.05f)
                curveTo(32.883f, 30.717f, 32.237f, 30.458f, 31.563f, 30.275f)
                curveTo(30.888f, 30.092f, 30.2f, 30f, 29.5f, 30f)
                curveTo(28.5f, 30f, 27.533f, 30.175f, 26.6f, 30.525f)
                curveTo(25.667f, 30.875f, 24.8f, 31.367f, 24f, 32f)
                close()
            }
        }
    }.build()
}