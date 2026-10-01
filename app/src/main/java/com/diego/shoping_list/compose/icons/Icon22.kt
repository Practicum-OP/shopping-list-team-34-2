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
fun Icon22(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon22",
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
                moveTo(28f, 35f)
                curveTo(27.717f, 35f, 27.479f, 34.904f, 27.288f, 34.713f)
                curveTo(27.096f, 34.521f, 27f, 34.283f, 27f, 34f)
                curveTo(27f, 33.717f, 27.096f, 33.479f, 27.288f, 33.287f)
                curveTo(27.479f, 33.096f, 27.717f, 33f, 28f, 33f)
                horizontalLineTo(31f)
                verticalLineTo(32f)
                horizontalLineTo(28f)
                curveTo(27.717f, 32f, 27.479f, 31.904f, 27.288f, 31.712f)
                curveTo(27.096f, 31.521f, 27f, 31.283f, 27f, 31f)
                curveTo(27f, 30.717f, 27.096f, 30.479f, 27.288f, 30.288f)
                curveTo(27.479f, 30.096f, 27.717f, 30f, 28f, 30f)
                horizontalLineTo(31f)
                verticalLineTo(29f)
                horizontalLineTo(28f)
                curveTo(27.717f, 29f, 27.479f, 28.904f, 27.288f, 28.712f)
                curveTo(27.096f, 28.521f, 27f, 28.283f, 27f, 28f)
                curveTo(27f, 27.717f, 27.096f, 27.479f, 27.288f, 27.288f)
                curveTo(27.479f, 27.096f, 27.717f, 27f, 28f, 27f)
                horizontalLineTo(31f)
                verticalLineTo(26f)
                horizontalLineTo(28f)
                curveTo(27.717f, 26f, 27.479f, 25.904f, 27.288f, 25.712f)
                curveTo(27.096f, 25.521f, 27f, 25.283f, 27f, 25f)
                curveTo(27f, 24.717f, 27.096f, 24.479f, 27.288f, 24.288f)
                curveTo(27.479f, 24.096f, 27.717f, 24f, 28f, 24f)
                horizontalLineTo(31f)
                verticalLineTo(23f)
                horizontalLineTo(28f)
                curveTo(27.717f, 23f, 27.479f, 22.904f, 27.288f, 22.712f)
                curveTo(27.096f, 22.521f, 27f, 22.283f, 27f, 22f)
                curveTo(27f, 21.717f, 27.096f, 21.479f, 27.288f, 21.288f)
                curveTo(27.479f, 21.096f, 27.717f, 21f, 28f, 21f)
                horizontalLineTo(31f)
                verticalLineTo(20f)
                horizontalLineTo(28f)
                curveTo(27.717f, 20f, 27.479f, 19.904f, 27.288f, 19.712f)
                curveTo(27.096f, 19.521f, 27f, 19.283f, 27f, 19f)
                curveTo(27f, 18.717f, 27.096f, 18.479f, 27.288f, 18.288f)
                curveTo(27.479f, 18.096f, 27.717f, 18f, 28f, 18f)
                horizontalLineTo(32f)
                curveTo(32.55f, 18f, 33.021f, 18.196f, 33.412f, 18.587f)
                curveTo(33.804f, 18.979f, 34f, 19.45f, 34f, 20f)
                verticalLineTo(33f)
                curveTo(34f, 33.55f, 33.804f, 34.021f, 33.412f, 34.412f)
                curveTo(33.021f, 34.804f, 32.55f, 35f, 32f, 35f)
                horizontalLineTo(28f)
                close()
                moveTo(20f, 27f)
                curveTo(21.1f, 27f, 22.042f, 26.458f, 22.825f, 25.375f)
                curveTo(23.608f, 24.292f, 24f, 23f, 24f, 21.5f)
                curveTo(24f, 20f, 23.608f, 18.708f, 22.825f, 17.625f)
                curveTo(22.042f, 16.542f, 21.1f, 16f, 20f, 16f)
                curveTo(18.9f, 16f, 17.958f, 16.542f, 17.175f, 17.625f)
                curveTo(16.392f, 18.708f, 16f, 20f, 16f, 21.5f)
                curveTo(16f, 23f, 16.392f, 24.292f, 17.175f, 25.375f)
                curveTo(17.958f, 26.458f, 18.9f, 27f, 20f, 27f)
                close()
                moveTo(20f, 35f)
                curveTo(19.2f, 35f, 18.542f, 34.704f, 18.025f, 34.112f)
                curveTo(17.508f, 33.521f, 17.308f, 32.825f, 17.425f, 32.025f)
                lineTo(17.825f, 28.5f)
                curveTo(16.692f, 27.95f, 15.771f, 27.046f, 15.063f, 25.788f)
                curveTo(14.354f, 24.529f, 14f, 23.1f, 14f, 21.5f)
                curveTo(14f, 19.417f, 14.583f, 17.646f, 15.75f, 16.188f)
                curveTo(16.917f, 14.729f, 18.333f, 14f, 20f, 14f)
                curveTo(21.667f, 14f, 23.083f, 14.729f, 24.25f, 16.188f)
                curveTo(25.417f, 17.646f, 26f, 19.417f, 26f, 21.5f)
                curveTo(26f, 23.1f, 25.646f, 24.529f, 24.938f, 25.788f)
                curveTo(24.229f, 27.046f, 23.308f, 27.95f, 22.175f, 28.5f)
                lineTo(22.575f, 32.025f)
                curveTo(22.692f, 32.825f, 22.492f, 33.521f, 21.975f, 34.112f)
                curveTo(21.458f, 34.704f, 20.8f, 35f, 20f, 35f)
                close()
            }
        }
    }.build()
}