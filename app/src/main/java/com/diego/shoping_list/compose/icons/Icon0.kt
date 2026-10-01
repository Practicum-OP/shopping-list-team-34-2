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
fun Icon0(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon0",
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
                moveTo(19f, 34f)
                curveTo(18.45f, 34f, 17.979f, 33.804f, 17.587f, 33.412f)
                curveTo(17.196f, 33.021f, 17f, 32.55f, 17f, 32f)
                curveTo(17f, 31.45f, 17.196f, 30.979f, 17.587f, 30.587f)
                curveTo(17.979f, 30.196f, 18.45f, 30f, 19f, 30f)
                curveTo(19.55f, 30f, 20.021f, 30.196f, 20.413f, 30.587f)
                curveTo(20.804f, 30.979f, 21f, 31.45f, 21f, 32f)
                curveTo(21f, 32.55f, 20.804f, 33.021f, 20.413f, 33.412f)
                curveTo(20.021f, 33.804f, 19.55f, 34f, 19f, 34f)
                close()
                moveTo(29f, 34f)
                curveTo(28.45f, 34f, 27.979f, 33.804f, 27.587f, 33.412f)
                curveTo(27.196f, 33.021f, 27f, 32.55f, 27f, 32f)
                curveTo(27f, 31.45f, 27.196f, 30.979f, 27.587f, 30.587f)
                curveTo(27.979f, 30.196f, 28.45f, 30f, 29f, 30f)
                curveTo(29.55f, 30f, 30.021f, 30.196f, 30.413f, 30.587f)
                curveTo(30.804f, 30.979f, 31f, 31.45f, 31f, 32f)
                curveTo(31f, 32.55f, 30.804f, 33.021f, 30.413f, 33.412f)
                curveTo(30.021f, 33.804f, 29.55f, 34f, 29f, 34f)
                close()
                moveTo(18.15f, 18f)
                lineTo(20.55f, 23f)
                horizontalLineTo(27.55f)
                lineTo(30.3f, 18f)
                horizontalLineTo(18.15f)
                close()
                moveTo(17.2f, 16f)
                horizontalLineTo(31.95f)
                curveTo(32.333f, 16f, 32.625f, 16.171f, 32.825f, 16.513f)
                curveTo(33.025f, 16.854f, 33.033f, 17.2f, 32.85f, 17.55f)
                lineTo(29.3f, 23.95f)
                curveTo(29.117f, 24.283f, 28.871f, 24.542f, 28.563f, 24.725f)
                curveTo(28.254f, 24.908f, 27.917f, 25f, 27.55f, 25f)
                horizontalLineTo(20.1f)
                lineTo(19f, 27f)
                horizontalLineTo(31f)
                verticalLineTo(29f)
                horizontalLineTo(19f)
                curveTo(18.25f, 29f, 17.683f, 28.671f, 17.3f, 28.013f)
                curveTo(16.917f, 27.354f, 16.9f, 26.7f, 17.25f, 26.05f)
                lineTo(18.6f, 23.6f)
                lineTo(15f, 16f)
                horizontalLineTo(13f)
                verticalLineTo(14f)
                horizontalLineTo(16.25f)
                lineTo(17.2f, 16f)
                close()
            }
        }
    }.build()
}
