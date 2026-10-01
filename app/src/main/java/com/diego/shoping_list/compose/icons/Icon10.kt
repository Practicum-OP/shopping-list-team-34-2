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
fun Icon10(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon10",
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
                moveTo(22.5f, 29.5f)
                horizontalLineTo(25.5f)
                verticalLineTo(27f)
                horizontalLineTo(28f)
                verticalLineTo(24f)
                horizontalLineTo(25.5f)
                verticalLineTo(21.5f)
                horizontalLineTo(22.5f)
                verticalLineTo(24f)
                horizontalLineTo(20f)
                verticalLineTo(27f)
                horizontalLineTo(22.5f)
                verticalLineTo(29.5f)
                close()
                moveTo(19f, 33f)
                curveTo(18.45f, 33f, 17.979f, 32.804f, 17.587f, 32.412f)
                curveTo(17.196f, 32.021f, 17f, 31.55f, 17f, 31f)
                verticalLineTo(20f)
                curveTo(17f, 19.45f, 17.196f, 18.979f, 17.587f, 18.587f)
                curveTo(17.979f, 18.196f, 18.45f, 18f, 19f, 18f)
                horizontalLineTo(29f)
                curveTo(29.55f, 18f, 30.021f, 18.196f, 30.413f, 18.587f)
                curveTo(30.804f, 18.979f, 31f, 19.45f, 31f, 20f)
                verticalLineTo(31f)
                curveTo(31f, 31.55f, 30.804f, 32.021f, 30.413f, 32.412f)
                curveTo(30.021f, 32.804f, 29.55f, 33f, 29f, 33f)
                horizontalLineTo(19f)
                close()
                moveTo(19f, 31f)
                horizontalLineTo(29f)
                verticalLineTo(20f)
                horizontalLineTo(19f)
                verticalLineTo(31f)
                close()
                moveTo(18f, 17f)
                verticalLineTo(15f)
                horizontalLineTo(30f)
                verticalLineTo(17f)
                horizontalLineTo(18f)
                close()
            }
        }
    }.build()
}