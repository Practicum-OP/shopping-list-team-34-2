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
fun Icon6(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon6",
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
                moveTo(16f, 29f)
                verticalLineTo(31f)
                horizontalLineTo(32f)
                verticalLineTo(29f)
                horizontalLineTo(16f)
                close()
                moveTo(16f, 18f)
                horizontalLineTo(18.2f)
                curveTo(18.117f, 17.85f, 18.063f, 17.692f, 18.038f, 17.525f)
                curveTo(18.013f, 17.358f, 18f, 17.183f, 18f, 17f)
                curveTo(18f, 16.167f, 18.292f, 15.458f, 18.875f, 14.875f)
                curveTo(19.458f, 14.292f, 20.167f, 14f, 21f, 14f)
                curveTo(21.5f, 14f, 21.962f, 14.129f, 22.388f, 14.387f)
                curveTo(22.813f, 14.646f, 23.183f, 14.967f, 23.5f, 15.35f)
                lineTo(24f, 16f)
                lineTo(24.5f, 15.35f)
                curveTo(24.8f, 14.95f, 25.167f, 14.625f, 25.6f, 14.375f)
                curveTo(26.033f, 14.125f, 26.5f, 14f, 27f, 14f)
                curveTo(27.833f, 14f, 28.542f, 14.292f, 29.125f, 14.875f)
                curveTo(29.708f, 15.458f, 30f, 16.167f, 30f, 17f)
                curveTo(30f, 17.183f, 29.987f, 17.358f, 29.962f, 17.525f)
                curveTo(29.938f, 17.692f, 29.883f, 17.85f, 29.8f, 18f)
                horizontalLineTo(32f)
                curveTo(32.55f, 18f, 33.021f, 18.196f, 33.412f, 18.587f)
                curveTo(33.804f, 18.979f, 34f, 19.45f, 34f, 20f)
                verticalLineTo(31f)
                curveTo(34f, 31.55f, 33.804f, 32.021f, 33.412f, 32.412f)
                curveTo(33.021f, 32.804f, 32.55f, 33f, 32f, 33f)
                horizontalLineTo(16f)
                curveTo(15.45f, 33f, 14.979f, 32.804f, 14.587f, 32.412f)
                curveTo(14.196f, 32.021f, 14f, 31.55f, 14f, 31f)
                verticalLineTo(20f)
                curveTo(14f, 19.45f, 14.196f, 18.979f, 14.587f, 18.587f)
                curveTo(14.979f, 18.196f, 15.45f, 18f, 16f, 18f)
                close()
                moveTo(16f, 26f)
                horizontalLineTo(32f)
                verticalLineTo(20f)
                horizontalLineTo(26.9f)
                lineTo(29f, 22.85f)
                lineTo(27.4f, 24f)
                lineTo(24f, 19.4f)
                lineTo(20.6f, 24f)
                lineTo(19f, 22.85f)
                lineTo(21.05f, 20f)
                horizontalLineTo(16f)
                verticalLineTo(26f)
                close()
                moveTo(21f, 18f)
                curveTo(21.283f, 18f, 21.521f, 17.904f, 21.712f, 17.712f)
                curveTo(21.904f, 17.521f, 22f, 17.283f, 22f, 17f)
                curveTo(22f, 16.717f, 21.904f, 16.479f, 21.712f, 16.288f)
                curveTo(21.521f, 16.096f, 21.283f, 16f, 21f, 16f)
                curveTo(20.717f, 16f, 20.479f, 16.096f, 20.288f, 16.288f)
                curveTo(20.096f, 16.479f, 20f, 16.717f, 20f, 17f)
                curveTo(20f, 17.283f, 20.096f, 17.521f, 20.288f, 17.712f)
                curveTo(20.479f, 17.904f, 20.717f, 18f, 21f, 18f)
                close()
                moveTo(27f, 18f)
                curveTo(27.283f, 18f, 27.521f, 17.904f, 27.712f, 17.712f)
                curveTo(27.904f, 17.521f, 28f, 17.283f, 28f, 17f)
                curveTo(28f, 16.717f, 27.904f, 16.479f, 27.712f, 16.288f)
                curveTo(27.521f, 16.096f, 27.283f, 16f, 27f, 16f)
                curveTo(26.717f, 16f, 26.479f, 16.096f, 26.288f, 16.288f)
                curveTo(26.096f, 16.479f, 26f, 16.717f, 26f, 17f)
                curveTo(26f, 17.283f, 26.096f, 17.521f, 26.288f, 17.712f)
                curveTo(26.479f, 17.904f, 26.717f, 18f, 27f, 18f)
                close()
            }
        }
    }.build()
}