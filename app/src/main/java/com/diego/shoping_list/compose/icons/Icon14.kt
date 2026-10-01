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
fun Icon14(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon14",
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
                moveTo(32.57f, 26.86f)
                lineTo(34f, 25.43f)
                lineTo(32.57f, 24f)
                lineTo(29f, 27.57f)
                lineTo(20.43f, 19f)
                lineTo(24f, 15.43f)
                lineTo(22.57f, 14f)
                lineTo(21.14f, 15.43f)
                lineTo(19.71f, 14f)
                lineTo(17.57f, 16.14f)
                lineTo(16.14f, 14.71f)
                lineTo(14.71f, 16.14f)
                lineTo(16.14f, 17.57f)
                lineTo(14f, 19.71f)
                lineTo(15.43f, 21.14f)
                lineTo(14f, 22.57f)
                lineTo(15.43f, 24f)
                lineTo(19f, 20.43f)
                lineTo(27.57f, 29f)
                lineTo(24f, 32.57f)
                lineTo(25.43f, 34f)
                lineTo(26.86f, 32.57f)
                lineTo(28.29f, 34f)
                lineTo(30.43f, 31.86f)
                lineTo(31.86f, 33.29f)
                lineTo(33.29f, 31.86f)
                lineTo(31.86f, 30.43f)
                lineTo(34f, 28.29f)
                lineTo(32.57f, 26.86f)
                close()
            }
        }
    }.build()
}