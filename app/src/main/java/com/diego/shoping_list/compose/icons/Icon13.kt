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
fun Icon13(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon13",
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
                moveTo(31f, 21.3f)
                verticalLineTo(16f)
                horizontalLineTo(28f)
                verticalLineTo(18.6f)
                lineTo(24f, 15f)
                lineTo(14f, 24f)
                horizontalLineTo(17f)
                verticalLineTo(32f)
                horizontalLineTo(23f)
                verticalLineTo(26f)
                horizontalLineTo(25f)
                verticalLineTo(32f)
                horizontalLineTo(31f)
                verticalLineTo(24f)
                horizontalLineTo(34f)
                lineTo(31f, 21.3f)
                close()
                moveTo(29f, 30f)
                horizontalLineTo(27f)
                verticalLineTo(24f)
                horizontalLineTo(21f)
                verticalLineTo(30f)
                horizontalLineTo(19f)
                verticalLineTo(22.19f)
                lineTo(24f, 17.69f)
                lineTo(29f, 22.19f)
                verticalLineTo(30f)
                close()
            }
            path(fill = SolidColor(Color(0xFF281805))) {
                moveTo(22f, 22f)
                horizontalLineTo(26f)
                curveTo(26f, 20.9f, 25.1f, 20f, 24f, 20f)
                curveTo(22.9f, 20f, 22f, 20.9f, 22f, 22f)
                close()
            }
        }
    }.build()
}