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
fun Icon5(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon5",
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
                moveTo(16f, 34f)
                curveTo(15.717f, 34f, 15.479f, 33.904f, 15.288f, 33.713f)
                curveTo(15.096f, 33.521f, 15f, 33.283f, 15f, 33f)
                verticalLineTo(28f)
                curveTo(15f, 27.45f, 15.196f, 26.979f, 15.587f, 26.587f)
                curveTo(15.979f, 26.196f, 16.45f, 26f, 17f, 26f)
                verticalLineTo(22f)
                curveTo(17f, 21.45f, 17.196f, 20.979f, 17.587f, 20.587f)
                curveTo(17.979f, 20.196f, 18.45f, 20f, 19f, 20f)
                horizontalLineTo(23f)
                verticalLineTo(18.55f)
                curveTo(22.7f, 18.35f, 22.458f, 18.108f, 22.275f, 17.825f)
                curveTo(22.092f, 17.542f, 22f, 17.2f, 22f, 16.8f)
                curveTo(22f, 16.55f, 22.05f, 16.304f, 22.15f, 16.063f)
                curveTo(22.25f, 15.821f, 22.4f, 15.6f, 22.6f, 15.4f)
                lineTo(24f, 14f)
                lineTo(25.4f, 15.4f)
                curveTo(25.6f, 15.6f, 25.75f, 15.821f, 25.85f, 16.063f)
                curveTo(25.95f, 16.304f, 26f, 16.55f, 26f, 16.8f)
                curveTo(26f, 17.2f, 25.908f, 17.542f, 25.725f, 17.825f)
                curveTo(25.542f, 18.108f, 25.3f, 18.35f, 25f, 18.55f)
                verticalLineTo(20f)
                horizontalLineTo(29f)
                curveTo(29.55f, 20f, 30.021f, 20.196f, 30.413f, 20.587f)
                curveTo(30.804f, 20.979f, 31f, 21.45f, 31f, 22f)
                verticalLineTo(26f)
                curveTo(31.55f, 26f, 32.021f, 26.196f, 32.412f, 26.587f)
                curveTo(32.804f, 26.979f, 33f, 27.45f, 33f, 28f)
                verticalLineTo(33f)
                curveTo(33f, 33.283f, 32.904f, 33.521f, 32.713f, 33.713f)
                curveTo(32.521f, 33.904f, 32.283f, 34f, 32f, 34f)
                horizontalLineTo(16f)
                close()
                moveTo(19f, 26f)
                horizontalLineTo(29f)
                verticalLineTo(22f)
                horizontalLineTo(19f)
                verticalLineTo(26f)
                close()
                moveTo(17f, 32f)
                horizontalLineTo(31f)
                verticalLineTo(28f)
                horizontalLineTo(17f)
                verticalLineTo(32f)
                close()
            }
        }
    }.build()
}