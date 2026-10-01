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
fun Icon4(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon4",
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
                moveTo(14f, 34f)
                lineTo(19f, 20f)
                lineTo(28f, 29f)
                lineTo(14f, 34f)
                close()
                moveTo(17.3f, 30.7f)
                lineTo(24.35f, 28.2f)
                lineTo(19.8f, 23.65f)
                lineTo(17.3f, 30.7f)
                close()
                moveTo(26.55f, 24.55f)
                lineTo(25.5f, 23.5f)
                lineTo(31.1f, 17.9f)
                curveTo(31.633f, 17.367f, 32.275f, 17.1f, 33.025f, 17.1f)
                curveTo(33.775f, 17.1f, 34.417f, 17.367f, 34.95f, 17.9f)
                lineTo(35.55f, 18.5f)
                lineTo(34.5f, 19.55f)
                lineTo(33.9f, 18.95f)
                curveTo(33.667f, 18.717f, 33.375f, 18.6f, 33.025f, 18.6f)
                curveTo(32.675f, 18.6f, 32.383f, 18.717f, 32.15f, 18.95f)
                lineTo(26.55f, 24.55f)
                close()
                moveTo(22.55f, 20.55f)
                lineTo(21.5f, 19.5f)
                lineTo(22.1f, 18.9f)
                curveTo(22.333f, 18.667f, 22.45f, 18.383f, 22.45f, 18.05f)
                curveTo(22.45f, 17.717f, 22.333f, 17.433f, 22.1f, 17.2f)
                lineTo(21.45f, 16.55f)
                lineTo(22.5f, 15.5f)
                lineTo(23.15f, 16.15f)
                curveTo(23.683f, 16.683f, 23.95f, 17.317f, 23.95f, 18.05f)
                curveTo(23.95f, 18.783f, 23.683f, 19.417f, 23.15f, 19.95f)
                lineTo(22.55f, 20.55f)
                close()
                moveTo(24.55f, 22.55f)
                lineTo(23.5f, 21.5f)
                lineTo(27.1f, 17.9f)
                curveTo(27.333f, 17.667f, 27.45f, 17.375f, 27.45f, 17.025f)
                curveTo(27.45f, 16.675f, 27.333f, 16.383f, 27.1f, 16.15f)
                lineTo(25.5f, 14.55f)
                lineTo(26.55f, 13.5f)
                lineTo(28.15f, 15.1f)
                curveTo(28.683f, 15.633f, 28.95f, 16.275f, 28.95f, 17.025f)
                curveTo(28.95f, 17.775f, 28.683f, 18.417f, 28.15f, 18.95f)
                lineTo(24.55f, 22.55f)
                close()
                moveTo(28.55f, 26.55f)
                lineTo(27.5f, 25.5f)
                lineTo(29.1f, 23.9f)
                curveTo(29.633f, 23.367f, 30.275f, 23.1f, 31.025f, 23.1f)
                curveTo(31.775f, 23.1f, 32.417f, 23.367f, 32.95f, 23.9f)
                lineTo(34.55f, 25.5f)
                lineTo(33.5f, 26.55f)
                lineTo(31.9f, 24.95f)
                curveTo(31.667f, 24.717f, 31.375f, 24.6f, 31.025f, 24.6f)
                curveTo(30.675f, 24.6f, 30.383f, 24.717f, 30.15f, 24.95f)
                lineTo(28.55f, 26.55f)
                close()
            }
        }
    }.build()
}