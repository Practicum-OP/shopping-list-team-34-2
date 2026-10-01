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
fun Icon8(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon8",
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
                moveTo(16.5f, 24.125f)
                curveTo(15.8f, 24.125f, 15.208f, 23.883f, 14.725f, 23.4f)
                curveTo(14.242f, 22.917f, 14f, 22.325f, 14f, 21.625f)
                curveTo(14f, 20.925f, 14.242f, 20.333f, 14.725f, 19.85f)
                curveTo(15.208f, 19.367f, 15.8f, 19.125f, 16.5f, 19.125f)
                curveTo(17.2f, 19.125f, 17.792f, 19.367f, 18.275f, 19.85f)
                curveTo(18.758f, 20.333f, 19f, 20.925f, 19f, 21.625f)
                curveTo(19f, 22.325f, 18.758f, 22.917f, 18.275f, 23.4f)
                curveTo(17.792f, 23.883f, 17.2f, 24.125f, 16.5f, 24.125f)
                close()
                moveTo(21f, 20.125f)
                curveTo(20.3f, 20.125f, 19.708f, 19.883f, 19.225f, 19.4f)
                curveTo(18.742f, 18.917f, 18.5f, 18.325f, 18.5f, 17.625f)
                curveTo(18.5f, 16.925f, 18.742f, 16.333f, 19.225f, 15.85f)
                curveTo(19.708f, 15.367f, 20.3f, 15.125f, 21f, 15.125f)
                curveTo(21.7f, 15.125f, 22.292f, 15.367f, 22.775f, 15.85f)
                curveTo(23.258f, 16.333f, 23.5f, 16.925f, 23.5f, 17.625f)
                curveTo(23.5f, 18.325f, 23.258f, 18.917f, 22.775f, 19.4f)
                curveTo(22.292f, 19.883f, 21.7f, 20.125f, 21f, 20.125f)
                close()
                moveTo(27f, 20.125f)
                curveTo(26.3f, 20.125f, 25.708f, 19.883f, 25.225f, 19.4f)
                curveTo(24.742f, 18.917f, 24.5f, 18.325f, 24.5f, 17.625f)
                curveTo(24.5f, 16.925f, 24.742f, 16.333f, 25.225f, 15.85f)
                curveTo(25.708f, 15.367f, 26.3f, 15.125f, 27f, 15.125f)
                curveTo(27.7f, 15.125f, 28.292f, 15.367f, 28.775f, 15.85f)
                curveTo(29.258f, 16.333f, 29.5f, 16.925f, 29.5f, 17.625f)
                curveTo(29.5f, 18.325f, 29.258f, 18.917f, 28.775f, 19.4f)
                curveTo(28.292f, 19.883f, 27.7f, 20.125f, 27f, 20.125f)
                close()
                moveTo(31.5f, 24.125f)
                curveTo(30.8f, 24.125f, 30.208f, 23.883f, 29.725f, 23.4f)
                curveTo(29.242f, 22.917f, 29f, 22.325f, 29f, 21.625f)
                curveTo(29f, 20.925f, 29.242f, 20.333f, 29.725f, 19.85f)
                curveTo(30.208f, 19.367f, 30.8f, 19.125f, 31.5f, 19.125f)
                curveTo(32.2f, 19.125f, 32.792f, 19.367f, 33.275f, 19.85f)
                curveTo(33.758f, 20.333f, 34f, 20.925f, 34f, 21.625f)
                curveTo(34f, 22.325f, 33.758f, 22.917f, 33.275f, 23.4f)
                curveTo(32.792f, 23.883f, 32.2f, 24.125f, 31.5f, 24.125f)
                close()
                moveTo(18.65f, 34.125f)
                curveTo(17.9f, 34.125f, 17.271f, 33.838f, 16.763f, 33.263f)
                curveTo(16.254f, 32.688f, 16f, 32.008f, 16f, 31.225f)
                curveTo(16f, 30.358f, 16.296f, 29.6f, 16.888f, 28.95f)
                curveTo(17.479f, 28.3f, 18.067f, 27.658f, 18.65f, 27.025f)
                curveTo(19.133f, 26.508f, 19.55f, 25.946f, 19.9f, 25.337f)
                curveTo(20.25f, 24.729f, 20.667f, 24.158f, 21.15f, 23.625f)
                curveTo(21.517f, 23.192f, 21.942f, 22.833f, 22.425f, 22.55f)
                curveTo(22.908f, 22.267f, 23.433f, 22.125f, 24f, 22.125f)
                curveTo(24.567f, 22.125f, 25.092f, 22.258f, 25.575f, 22.525f)
                curveTo(26.058f, 22.792f, 26.483f, 23.142f, 26.85f, 23.575f)
                curveTo(27.317f, 24.108f, 27.729f, 24.683f, 28.087f, 25.3f)
                curveTo(28.446f, 25.917f, 28.867f, 26.492f, 29.35f, 27.025f)
                curveTo(29.933f, 27.658f, 30.521f, 28.3f, 31.112f, 28.95f)
                curveTo(31.704f, 29.6f, 32f, 30.358f, 32f, 31.225f)
                curveTo(32f, 32.008f, 31.746f, 32.688f, 31.237f, 33.263f)
                curveTo(30.729f, 33.838f, 30.1f, 34.125f, 29.35f, 34.125f)
                curveTo(28.45f, 34.125f, 27.558f, 34.05f, 26.675f, 33.9f)
                curveTo(25.792f, 33.75f, 24.9f, 33.675f, 24f, 33.675f)
                curveTo(23.1f, 33.675f, 22.208f, 33.75f, 21.325f, 33.9f)
                curveTo(20.442f, 34.05f, 19.55f, 34.125f, 18.65f, 34.125f)
                close()
            }
        }
    }.build()
}