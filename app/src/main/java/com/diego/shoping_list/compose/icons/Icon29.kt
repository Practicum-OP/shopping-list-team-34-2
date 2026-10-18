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
fun Icon29(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon29",
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
            path(fill = SolidColor(containerColor)) {
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
            path(fill = SolidColor(contentColor)) {
                moveTo(20f, 29f)
                curveTo(20.283f, 29f, 20.521f, 28.904f, 20.712f, 28.712f)
                curveTo(20.904f, 28.521f, 21f, 28.283f, 21f, 28f)
                curveTo(21f, 27.717f, 20.904f, 27.479f, 20.712f, 27.288f)
                curveTo(20.521f, 27.096f, 20.283f, 27f, 20f, 27f)
                curveTo(19.717f, 27f, 19.479f, 27.096f, 19.288f, 27.288f)
                curveTo(19.096f, 27.479f, 19f, 27.717f, 19f, 28f)
                curveTo(19f, 28.283f, 19.096f, 28.521f, 19.288f, 28.712f)
                curveTo(19.479f, 28.904f, 19.717f, 29f, 20f, 29f)
                close()
                moveTo(20f, 25f)
                curveTo(20.283f, 25f, 20.521f, 24.904f, 20.712f, 24.712f)
                curveTo(20.904f, 24.521f, 21f, 24.283f, 21f, 24f)
                curveTo(21f, 23.717f, 20.904f, 23.479f, 20.712f, 23.288f)
                curveTo(20.521f, 23.096f, 20.283f, 23f, 20f, 23f)
                curveTo(19.717f, 23f, 19.479f, 23.096f, 19.288f, 23.288f)
                curveTo(19.096f, 23.479f, 19f, 23.717f, 19f, 24f)
                curveTo(19f, 24.283f, 19.096f, 24.521f, 19.288f, 24.712f)
                curveTo(19.479f, 24.904f, 19.717f, 25f, 20f, 25f)
                close()
                moveTo(20f, 21f)
                curveTo(20.283f, 21f, 20.521f, 20.904f, 20.712f, 20.712f)
                curveTo(20.904f, 20.521f, 21f, 20.283f, 21f, 20f)
                curveTo(21f, 19.717f, 20.904f, 19.479f, 20.712f, 19.288f)
                curveTo(20.521f, 19.096f, 20.283f, 19f, 20f, 19f)
                curveTo(19.717f, 19f, 19.479f, 19.096f, 19.288f, 19.288f)
                curveTo(19.096f, 19.479f, 19f, 19.717f, 19f, 20f)
                curveTo(19f, 20.283f, 19.096f, 20.521f, 19.288f, 20.712f)
                curveTo(19.479f, 20.904f, 19.717f, 21f, 20f, 21f)
                close()
                moveTo(23f, 29f)
                horizontalLineTo(29f)
                verticalLineTo(27f)
                horizontalLineTo(23f)
                verticalLineTo(29f)
                close()
                moveTo(23f, 25f)
                horizontalLineTo(29f)
                verticalLineTo(23f)
                horizontalLineTo(23f)
                verticalLineTo(25f)
                close()
                moveTo(23f, 21f)
                horizontalLineTo(29f)
                verticalLineTo(19f)
                horizontalLineTo(23f)
                verticalLineTo(21f)
                close()
                moveTo(17f, 33f)
                curveTo(16.45f, 33f, 15.979f, 32.804f, 15.587f, 32.412f)
                curveTo(15.196f, 32.021f, 15f, 31.55f, 15f, 31f)
                verticalLineTo(17f)
                curveTo(15f, 16.45f, 15.196f, 15.979f, 15.587f, 15.587f)
                curveTo(15.979f, 15.196f, 16.45f, 15f, 17f, 15f)
                horizontalLineTo(31f)
                curveTo(31.55f, 15f, 32.021f, 15.196f, 32.412f, 15.587f)
                curveTo(32.804f, 15.979f, 33f, 16.45f, 33f, 17f)
                verticalLineTo(31f)
                curveTo(33f, 31.55f, 32.804f, 32.021f, 32.412f, 32.412f)
                curveTo(32.021f, 32.804f, 31.55f, 33f, 31f, 33f)
                horizontalLineTo(17f)
                close()
                moveTo(17f, 31f)
                horizontalLineTo(31f)
                verticalLineTo(17f)
                horizontalLineTo(17f)
                verticalLineTo(31f)
                close()
            }
        }
    }.build()
}
