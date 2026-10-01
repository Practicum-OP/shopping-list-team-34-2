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
fun Icon20(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon20",
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
                moveTo(19f, 33f)
                curveTo(18.45f, 33f, 17.979f, 32.804f, 17.587f, 32.412f)
                curveTo(17.196f, 32.021f, 17f, 31.55f, 17f, 31f)
                verticalLineTo(20f)
                curveTo(17f, 19.45f, 17.196f, 18.979f, 17.587f, 18.587f)
                curveTo(17.979f, 18.196f, 18.45f, 18f, 19f, 18f)
                horizontalLineTo(21f)
                verticalLineTo(16f)
                curveTo(21f, 15.45f, 21.196f, 14.979f, 21.587f, 14.587f)
                curveTo(21.979f, 14.196f, 22.45f, 14f, 23f, 14f)
                horizontalLineTo(25f)
                curveTo(25.55f, 14f, 26.021f, 14.196f, 26.413f, 14.587f)
                curveTo(26.804f, 14.979f, 27f, 15.45f, 27f, 16f)
                verticalLineTo(18f)
                horizontalLineTo(29f)
                curveTo(29.55f, 18f, 30.021f, 18.196f, 30.413f, 18.587f)
                curveTo(30.804f, 18.979f, 31f, 19.45f, 31f, 20f)
                verticalLineTo(31f)
                curveTo(31f, 31.55f, 30.804f, 32.021f, 30.413f, 32.412f)
                curveTo(30.021f, 32.804f, 29.55f, 33f, 29f, 33f)
                curveTo(29f, 33.283f, 28.904f, 33.521f, 28.712f, 33.713f)
                curveTo(28.521f, 33.904f, 28.283f, 34f, 28f, 34f)
                curveTo(27.717f, 34f, 27.479f, 33.904f, 27.288f, 33.713f)
                curveTo(27.096f, 33.521f, 27f, 33.283f, 27f, 33f)
                horizontalLineTo(21f)
                curveTo(21f, 33.283f, 20.904f, 33.521f, 20.712f, 33.713f)
                curveTo(20.521f, 33.904f, 20.283f, 34f, 20f, 34f)
                curveTo(19.717f, 34f, 19.479f, 33.904f, 19.288f, 33.713f)
                curveTo(19.096f, 33.521f, 19f, 33.283f, 19f, 33f)
                close()
                moveTo(19f, 31f)
                horizontalLineTo(29f)
                verticalLineTo(20f)
                horizontalLineTo(19f)
                verticalLineTo(31f)
                close()
                moveTo(21f, 30f)
                horizontalLineTo(23f)
                verticalLineTo(21f)
                horizontalLineTo(21f)
                verticalLineTo(30f)
                close()
                moveTo(25f, 30f)
                horizontalLineTo(27f)
                verticalLineTo(21f)
                horizontalLineTo(25f)
                verticalLineTo(30f)
                close()
                moveTo(23f, 18f)
                horizontalLineTo(25f)
                verticalLineTo(16f)
                horizontalLineTo(23f)
                verticalLineTo(18f)
                close()
            }
        }
    }.build()
}