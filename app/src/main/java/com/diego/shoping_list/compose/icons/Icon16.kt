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
fun Icon16(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon16",
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
                moveTo(33.58f, 28.09f)
                lineTo(32.49f, 20.43f)
                curveTo(32.21f, 18.46f, 30.52f, 17f, 28.53f, 17f)
                horizontalLineTo(19.47f)
                curveTo(17.48f, 17f, 15.79f, 18.46f, 15.51f, 20.43f)
                lineTo(14.42f, 28.09f)
                curveTo(14.2f, 29.63f, 15.39f, 31f, 16.94f, 31f)
                curveTo(17.62f, 31f, 18.26f, 30.73f, 18.74f, 30.25f)
                lineTo(21f, 28f)
                horizontalLineTo(27f)
                lineTo(29.25f, 30.25f)
                curveTo(29.73f, 30.73f, 30.38f, 31f, 31.05f, 31f)
                curveTo(32.61f, 31f, 33.8f, 29.63f, 33.58f, 28.09f)
                close()
                moveTo(31.48f, 28.81f)
                curveTo(31.4f, 28.9f, 31.27f, 29f, 31.06f, 29f)
                curveTo(30.91f, 29f, 30.77f, 28.94f, 30.67f, 28.84f)
                lineTo(27.83f, 26f)
                horizontalLineTo(20.17f)
                lineTo(17.33f, 28.84f)
                curveTo(17.23f, 28.94f, 17.09f, 29f, 16.94f, 29f)
                curveTo(16.73f, 29f, 16.6f, 28.9f, 16.52f, 28.81f)
                curveTo(16.44f, 28.72f, 16.36f, 28.58f, 16.39f, 28.37f)
                lineTo(17.48f, 20.71f)
                curveTo(17.63f, 19.74f, 18.48f, 19f, 19.47f, 19f)
                horizontalLineTo(28.53f)
                curveTo(29.52f, 19f, 30.37f, 19.74f, 30.51f, 20.72f)
                lineTo(31.6f, 28.38f)
                curveTo(31.63f, 28.58f, 31.55f, 28.72f, 31.48f, 28.81f)
                close()
            }
            path(fill = SolidColor(Color(0xFF281805))) {
                moveTo(21f, 20f)
                horizontalLineTo(20f)
                verticalLineTo(22f)
                horizontalLineTo(18f)
                verticalLineTo(23f)
                horizontalLineTo(20f)
                verticalLineTo(25f)
                horizontalLineTo(21f)
                verticalLineTo(23f)
                horizontalLineTo(23f)
                verticalLineTo(22f)
                horizontalLineTo(21f)
                verticalLineTo(20f)
                close()
            }
            path(fill = SolidColor(Color(0xFF281805))) {
                moveTo(29f, 25f)
                curveTo(29.552f, 25f, 30f, 24.552f, 30f, 24f)
                curveTo(30f, 23.448f, 29.552f, 23f, 29f, 23f)
                curveTo(28.448f, 23f, 28f, 23.448f, 28f, 24f)
                curveTo(28f, 24.552f, 28.448f, 25f, 29f, 25f)
                close()
            }
            path(fill = SolidColor(Color(0xFF281805))) {
                moveTo(27f, 22f)
                curveTo(27.552f, 22f, 28f, 21.552f, 28f, 21f)
                curveTo(28f, 20.448f, 27.552f, 20f, 27f, 20f)
                curveTo(26.448f, 20f, 26f, 20.448f, 26f, 21f)
                curveTo(26f, 21.552f, 26.448f, 22f, 27f, 22f)
                close()
            }
        }
    }.build()
}