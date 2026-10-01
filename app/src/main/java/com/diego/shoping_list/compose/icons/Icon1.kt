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
fun Icon1(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon1",
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
                moveTo(18f, 34f)
                curveTo(17.45f, 34f, 16.979f, 33.804f, 16.587f, 33.412f)
                curveTo(16.196f, 33.021f, 16f, 32.55f, 16f, 32f)
                verticalLineTo(20f)
                curveTo(16f, 19.45f, 16.196f, 18.979f, 16.587f, 18.587f)
                curveTo(16.979f, 18.196f, 17.45f, 18f, 18f, 18f)
                horizontalLineTo(20f)
                curveTo(20f, 16.9f, 20.392f, 15.958f, 21.175f, 15.175f)
                curveTo(21.958f, 14.392f, 22.9f, 14f, 24f, 14f)
                curveTo(25.1f, 14f, 26.042f, 14.392f, 26.825f, 15.175f)
                curveTo(27.608f, 15.958f, 28f, 16.9f, 28f, 18f)
                horizontalLineTo(30f)
                curveTo(30.55f, 18f, 31.021f, 18.196f, 31.413f, 18.587f)
                curveTo(31.804f, 18.979f, 32f, 19.45f, 32f, 20f)
                verticalLineTo(32f)
                curveTo(32f, 32.55f, 31.804f, 33.021f, 31.413f, 33.412f)
                curveTo(31.021f, 33.804f, 30.55f, 34f, 30f, 34f)
                horizontalLineTo(18f)
                close()
                moveTo(18f, 32f)
                horizontalLineTo(30f)
                verticalLineTo(20f)
                horizontalLineTo(28f)
                verticalLineTo(22f)
                curveTo(28f, 22.283f, 27.904f, 22.521f, 27.712f, 22.712f)
                curveTo(27.521f, 22.904f, 27.283f, 23f, 27f, 23f)
                curveTo(26.717f, 23f, 26.479f, 22.904f, 26.288f, 22.712f)
                curveTo(26.096f, 22.521f, 26f, 22.283f, 26f, 22f)
                verticalLineTo(20f)
                horizontalLineTo(22f)
                verticalLineTo(22f)
                curveTo(22f, 22.283f, 21.904f, 22.521f, 21.712f, 22.712f)
                curveTo(21.521f, 22.904f, 21.283f, 23f, 21f, 23f)
                curveTo(20.717f, 23f, 20.479f, 22.904f, 20.288f, 22.712f)
                curveTo(20.096f, 22.521f, 20f, 22.283f, 20f, 22f)
                verticalLineTo(20f)
                horizontalLineTo(18f)
                verticalLineTo(32f)
                close()
                moveTo(22f, 18f)
                horizontalLineTo(26f)
                curveTo(26f, 17.45f, 25.804f, 16.979f, 25.413f, 16.587f)
                curveTo(25.021f, 16.196f, 24.55f, 16f, 24f, 16f)
                curveTo(23.45f, 16f, 22.979f, 16.196f, 22.587f, 16.587f)
                curveTo(22.196f, 16.979f, 22f, 17.45f, 22f, 18f)
                close()
            }
        }
    }.build()
}
