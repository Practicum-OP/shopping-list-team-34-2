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
fun Icon23(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon23",
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
                moveTo(24f, 29.5f)
                curveTo(25.25f, 29.5f, 26.313f, 29.063f, 27.188f, 28.188f)
                curveTo(28.063f, 27.313f, 28.5f, 26.25f, 28.5f, 25f)
                curveTo(28.5f, 23.75f, 28.063f, 22.688f, 27.188f, 21.813f)
                curveTo(26.313f, 20.938f, 25.25f, 20.5f, 24f, 20.5f)
                curveTo(22.75f, 20.5f, 21.688f, 20.938f, 20.813f, 21.813f)
                curveTo(19.938f, 22.688f, 19.5f, 23.75f, 19.5f, 25f)
                curveTo(19.5f, 26.25f, 19.938f, 27.313f, 20.813f, 28.188f)
                curveTo(21.688f, 29.063f, 22.75f, 29.5f, 24f, 29.5f)
                close()
                moveTo(24f, 27.5f)
                curveTo(23.3f, 27.5f, 22.708f, 27.258f, 22.225f, 26.775f)
                curveTo(21.742f, 26.292f, 21.5f, 25.7f, 21.5f, 25f)
                curveTo(21.5f, 24.3f, 21.742f, 23.708f, 22.225f, 23.225f)
                curveTo(22.708f, 22.742f, 23.3f, 22.5f, 24f, 22.5f)
                curveTo(24.7f, 22.5f, 25.292f, 22.742f, 25.775f, 23.225f)
                curveTo(26.258f, 23.708f, 26.5f, 24.3f, 26.5f, 25f)
                curveTo(26.5f, 25.7f, 26.258f, 26.292f, 25.775f, 26.775f)
                curveTo(25.292f, 27.258f, 24.7f, 27.5f, 24f, 27.5f)
                close()
                moveTo(16f, 33f)
                curveTo(15.45f, 33f, 14.979f, 32.804f, 14.587f, 32.412f)
                curveTo(14.196f, 32.021f, 14f, 31.55f, 14f, 31f)
                verticalLineTo(19f)
                curveTo(14f, 18.45f, 14.196f, 17.979f, 14.587f, 17.587f)
                curveTo(14.979f, 17.196f, 15.45f, 17f, 16f, 17f)
                horizontalLineTo(19.15f)
                lineTo(21f, 15f)
                horizontalLineTo(27f)
                lineTo(28.85f, 17f)
                horizontalLineTo(32f)
                curveTo(32.55f, 17f, 33.021f, 17.196f, 33.412f, 17.587f)
                curveTo(33.804f, 17.979f, 34f, 18.45f, 34f, 19f)
                verticalLineTo(31f)
                curveTo(34f, 31.55f, 33.804f, 32.021f, 33.412f, 32.412f)
                curveTo(33.021f, 32.804f, 32.55f, 33f, 32f, 33f)
                horizontalLineTo(16f)
                close()
                moveTo(16f, 31f)
                horizontalLineTo(32f)
                verticalLineTo(19f)
                horizontalLineTo(27.95f)
                lineTo(26.125f, 17f)
                horizontalLineTo(21.875f)
                lineTo(20.05f, 19f)
                horizontalLineTo(16f)
                verticalLineTo(31f)
                close()
            }
        }
    }.build()
}