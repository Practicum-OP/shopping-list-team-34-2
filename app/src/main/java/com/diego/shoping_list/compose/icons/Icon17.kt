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
fun Icon17(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon17",
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
                moveTo(24f, 34f)
                curveTo(22.633f, 34f, 21.342f, 33.737f, 20.125f, 33.213f)
                curveTo(18.908f, 32.688f, 17.846f, 31.971f, 16.938f, 31.063f)
                curveTo(16.029f, 30.154f, 15.313f, 29.092f, 14.788f, 27.875f)
                curveTo(14.262f, 26.658f, 14f, 25.367f, 14f, 24f)
                curveTo(14f, 22.617f, 14.271f, 21.317f, 14.813f, 20.1f)
                curveTo(15.354f, 18.883f, 16.087f, 17.825f, 17.013f, 16.925f)
                curveTo(17.938f, 16.025f, 19.017f, 15.313f, 20.25f, 14.788f)
                curveTo(21.483f, 14.262f, 22.8f, 14f, 24.2f, 14f)
                curveTo(25.533f, 14f, 26.792f, 14.229f, 27.975f, 14.688f)
                curveTo(29.158f, 15.146f, 30.196f, 15.779f, 31.087f, 16.587f)
                curveTo(31.979f, 17.396f, 32.688f, 18.354f, 33.213f, 19.462f)
                curveTo(33.737f, 20.571f, 34f, 21.767f, 34f, 23.05f)
                curveTo(34f, 24.967f, 33.417f, 26.438f, 32.25f, 27.462f)
                curveTo(31.083f, 28.487f, 29.667f, 29f, 28f, 29f)
                horizontalLineTo(26.15f)
                curveTo(26f, 29f, 25.896f, 29.042f, 25.837f, 29.125f)
                curveTo(25.779f, 29.208f, 25.75f, 29.3f, 25.75f, 29.4f)
                curveTo(25.75f, 29.6f, 25.875f, 29.888f, 26.125f, 30.263f)
                curveTo(26.375f, 30.638f, 26.5f, 31.067f, 26.5f, 31.55f)
                curveTo(26.5f, 32.383f, 26.271f, 33f, 25.813f, 33.4f)
                curveTo(25.354f, 33.8f, 24.75f, 34f, 24f, 34f)
                close()
                moveTo(18.5f, 25f)
                curveTo(18.933f, 25f, 19.292f, 24.858f, 19.575f, 24.575f)
                curveTo(19.858f, 24.292f, 20f, 23.933f, 20f, 23.5f)
                curveTo(20f, 23.067f, 19.858f, 22.708f, 19.575f, 22.425f)
                curveTo(19.292f, 22.142f, 18.933f, 22f, 18.5f, 22f)
                curveTo(18.067f, 22f, 17.708f, 22.142f, 17.425f, 22.425f)
                curveTo(17.142f, 22.708f, 17f, 23.067f, 17f, 23.5f)
                curveTo(17f, 23.933f, 17.142f, 24.292f, 17.425f, 24.575f)
                curveTo(17.708f, 24.858f, 18.067f, 25f, 18.5f, 25f)
                close()
                moveTo(21.5f, 21f)
                curveTo(21.933f, 21f, 22.292f, 20.858f, 22.575f, 20.575f)
                curveTo(22.858f, 20.292f, 23f, 19.933f, 23f, 19.5f)
                curveTo(23f, 19.067f, 22.858f, 18.708f, 22.575f, 18.425f)
                curveTo(22.292f, 18.142f, 21.933f, 18f, 21.5f, 18f)
                curveTo(21.067f, 18f, 20.708f, 18.142f, 20.425f, 18.425f)
                curveTo(20.142f, 18.708f, 20f, 19.067f, 20f, 19.5f)
                curveTo(20f, 19.933f, 20.142f, 20.292f, 20.425f, 20.575f)
                curveTo(20.708f, 20.858f, 21.067f, 21f, 21.5f, 21f)
                close()
                moveTo(26.5f, 21f)
                curveTo(26.933f, 21f, 27.292f, 20.858f, 27.575f, 20.575f)
                curveTo(27.858f, 20.292f, 28f, 19.933f, 28f, 19.5f)
                curveTo(28f, 19.067f, 27.858f, 18.708f, 27.575f, 18.425f)
                curveTo(27.292f, 18.142f, 26.933f, 18f, 26.5f, 18f)
                curveTo(26.067f, 18f, 25.708f, 18.142f, 25.425f, 18.425f)
                curveTo(25.142f, 18.708f, 25f, 19.067f, 25f, 19.5f)
                curveTo(25f, 19.933f, 25.142f, 20.292f, 25.425f, 20.575f)
                curveTo(25.708f, 20.858f, 26.067f, 21f, 26.5f, 21f)
                close()
                moveTo(29.5f, 25f)
                curveTo(29.933f, 25f, 30.292f, 24.858f, 30.575f, 24.575f)
                curveTo(30.858f, 24.292f, 31f, 23.933f, 31f, 23.5f)
                curveTo(31f, 23.067f, 30.858f, 22.708f, 30.575f, 22.425f)
                curveTo(30.292f, 22.142f, 29.933f, 22f, 29.5f, 22f)
                curveTo(29.067f, 22f, 28.708f, 22.142f, 28.425f, 22.425f)
                curveTo(28.142f, 22.708f, 28f, 23.067f, 28f, 23.5f)
                curveTo(28f, 23.933f, 28.142f, 24.292f, 28.425f, 24.575f)
                curveTo(28.708f, 24.858f, 29.067f, 25f, 29.5f, 25f)
                close()
                moveTo(24f, 32f)
                curveTo(24.15f, 32f, 24.271f, 31.958f, 24.362f, 31.875f)
                curveTo(24.454f, 31.792f, 24.5f, 31.683f, 24.5f, 31.55f)
                curveTo(24.5f, 31.317f, 24.375f, 31.042f, 24.125f, 30.725f)
                curveTo(23.875f, 30.408f, 23.75f, 29.933f, 23.75f, 29.3f)
                curveTo(23.75f, 28.6f, 23.992f, 28.042f, 24.475f, 27.625f)
                curveTo(24.958f, 27.208f, 25.55f, 27f, 26.25f, 27f)
                horizontalLineTo(28f)
                curveTo(29.1f, 27f, 30.042f, 26.679f, 30.825f, 26.038f)
                curveTo(31.608f, 25.396f, 32f, 24.4f, 32f, 23.05f)
                curveTo(32f, 21.033f, 31.229f, 19.354f, 29.688f, 18.013f)
                curveTo(28.146f, 16.671f, 26.317f, 16f, 24.2f, 16f)
                curveTo(21.933f, 16f, 20f, 16.775f, 18.4f, 18.325f)
                curveTo(16.8f, 19.875f, 16f, 21.767f, 16f, 24f)
                curveTo(16f, 26.217f, 16.779f, 28.104f, 18.337f, 29.663f)
                curveTo(19.896f, 31.221f, 21.783f, 32f, 24f, 32f)
                close()
            }
        }
    }.build()
}