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
fun Icon26(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon26",
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
                moveTo(15f, 29.2f)
                curveTo(15f, 28.933f, 15.087f, 28.708f, 15.262f, 28.525f)
                curveTo(15.438f, 28.342f, 15.65f, 28.25f, 15.9f, 28.25f)
                curveTo(16.033f, 28.25f, 16.163f, 28.271f, 16.288f, 28.313f)
                curveTo(16.413f, 28.354f, 16.533f, 28.417f, 16.65f, 28.5f)
                curveTo(16.867f, 28.633f, 17.083f, 28.75f, 17.3f, 28.85f)
                curveTo(17.517f, 28.95f, 17.75f, 29f, 18f, 29f)
                curveTo(18.55f, 29f, 19.021f, 28.804f, 19.413f, 28.413f)
                curveTo(19.804f, 28.021f, 20f, 27.55f, 20f, 27f)
                curveTo(20f, 26.45f, 19.804f, 25.979f, 19.413f, 25.587f)
                curveTo(19.021f, 25.196f, 18.55f, 25f, 18f, 25f)
                curveTo(17.75f, 25f, 17.508f, 25.042f, 17.275f, 25.125f)
                curveTo(17.042f, 25.208f, 16.833f, 25.333f, 16.65f, 25.5f)
                curveTo(16.55f, 25.583f, 16.433f, 25.646f, 16.3f, 25.688f)
                curveTo(16.167f, 25.729f, 16.033f, 25.75f, 15.9f, 25.75f)
                curveTo(15.65f, 25.75f, 15.438f, 25.658f, 15.262f, 25.475f)
                curveTo(15.087f, 25.292f, 15f, 25.067f, 15f, 24.8f)
                verticalLineTo(21f)
                curveTo(15f, 20.717f, 15.096f, 20.479f, 15.288f, 20.288f)
                curveTo(15.479f, 20.096f, 15.717f, 20f, 16f, 20f)
                horizontalLineTo(19.75f)
                curveTo(19.667f, 19.75f, 19.604f, 19.5f, 19.563f, 19.25f)
                curveTo(19.521f, 19f, 19.5f, 18.75f, 19.5f, 18.5f)
                curveTo(19.5f, 17.25f, 19.938f, 16.188f, 20.813f, 15.313f)
                curveTo(21.688f, 14.438f, 22.75f, 14f, 24f, 14f)
                curveTo(25.25f, 14f, 26.313f, 14.438f, 27.188f, 15.313f)
                curveTo(28.063f, 16.188f, 28.5f, 17.25f, 28.5f, 18.5f)
                curveTo(28.5f, 18.75f, 28.479f, 19f, 28.438f, 19.25f)
                curveTo(28.396f, 19.5f, 28.333f, 19.75f, 28.25f, 20f)
                horizontalLineTo(32f)
                curveTo(32.283f, 20f, 32.521f, 20.096f, 32.713f, 20.288f)
                curveTo(32.904f, 20.479f, 33f, 20.717f, 33f, 21f)
                verticalLineTo(24.8f)
                curveTo(33f, 25.083f, 32.904f, 25.321f, 32.713f, 25.513f)
                curveTo(32.521f, 25.704f, 32.283f, 25.8f, 32f, 25.8f)
                curveTo(31.867f, 25.8f, 31.75f, 25.771f, 31.65f, 25.712f)
                curveTo(31.55f, 25.654f, 31.45f, 25.583f, 31.35f, 25.5f)
                curveTo(31.167f, 25.333f, 30.958f, 25.208f, 30.725f, 25.125f)
                curveTo(30.492f, 25.042f, 30.25f, 25f, 30f, 25f)
                curveTo(29.45f, 25f, 28.979f, 25.196f, 28.587f, 25.587f)
                curveTo(28.196f, 25.979f, 28f, 26.45f, 28f, 27f)
                curveTo(28f, 27.55f, 28.196f, 28.021f, 28.587f, 28.413f)
                curveTo(28.979f, 28.804f, 29.45f, 29f, 30f, 29f)
                curveTo(30.25f, 29f, 30.492f, 28.958f, 30.725f, 28.875f)
                curveTo(30.958f, 28.792f, 31.167f, 28.667f, 31.35f, 28.5f)
                curveTo(31.433f, 28.417f, 31.529f, 28.346f, 31.638f, 28.288f)
                curveTo(31.746f, 28.229f, 31.867f, 28.2f, 32f, 28.2f)
                curveTo(32.283f, 28.2f, 32.521f, 28.296f, 32.713f, 28.487f)
                curveTo(32.904f, 28.679f, 33f, 28.917f, 33f, 29.2f)
                verticalLineTo(33f)
                curveTo(33f, 33.283f, 32.904f, 33.521f, 32.713f, 33.713f)
                curveTo(32.521f, 33.904f, 32.283f, 34f, 32f, 34f)
                horizontalLineTo(16f)
                curveTo(15.717f, 34f, 15.479f, 33.904f, 15.288f, 33.713f)
                curveTo(15.096f, 33.521f, 15f, 33.283f, 15f, 33f)
                verticalLineTo(29.2f)
                close()
                moveTo(17f, 32f)
                horizontalLineTo(31f)
                verticalLineTo(30.85f)
                curveTo(30.833f, 30.9f, 30.671f, 30.938f, 30.513f, 30.962f)
                curveTo(30.354f, 30.987f, 30.183f, 31f, 30f, 31f)
                curveTo(28.9f, 31f, 27.958f, 30.608f, 27.175f, 29.825f)
                curveTo(26.392f, 29.042f, 26f, 28.1f, 26f, 27f)
                curveTo(26f, 25.9f, 26.392f, 24.958f, 27.175f, 24.175f)
                curveTo(27.958f, 23.392f, 28.9f, 23f, 30f, 23f)
                curveTo(30.183f, 23f, 30.354f, 23.013f, 30.513f, 23.038f)
                curveTo(30.671f, 23.063f, 30.833f, 23.1f, 31f, 23.15f)
                verticalLineTo(22f)
                horizontalLineTo(26.45f)
                curveTo(26.167f, 22f, 25.929f, 21.908f, 25.737f, 21.725f)
                curveTo(25.546f, 21.542f, 25.45f, 21.317f, 25.45f, 21.05f)
                curveTo(25.45f, 20.917f, 25.471f, 20.779f, 25.513f, 20.638f)
                curveTo(25.554f, 20.496f, 25.633f, 20.383f, 25.75f, 20.3f)
                curveTo(26.033f, 20.1f, 26.229f, 19.837f, 26.337f, 19.513f)
                curveTo(26.446f, 19.188f, 26.5f, 18.85f, 26.5f, 18.5f)
                curveTo(26.5f, 17.8f, 26.258f, 17.208f, 25.775f, 16.725f)
                curveTo(25.292f, 16.242f, 24.7f, 16f, 24f, 16f)
                curveTo(23.3f, 16f, 22.708f, 16.242f, 22.225f, 16.725f)
                curveTo(21.742f, 17.208f, 21.5f, 17.8f, 21.5f, 18.5f)
                curveTo(21.5f, 18.85f, 21.554f, 19.188f, 21.663f, 19.513f)
                curveTo(21.771f, 19.837f, 21.967f, 20.1f, 22.25f, 20.3f)
                curveTo(22.367f, 20.383f, 22.446f, 20.487f, 22.487f, 20.612f)
                curveTo(22.529f, 20.737f, 22.55f, 20.867f, 22.55f, 21f)
                curveTo(22.55f, 21.283f, 22.454f, 21.521f, 22.263f, 21.712f)
                curveTo(22.071f, 21.904f, 21.833f, 22f, 21.55f, 22f)
                horizontalLineTo(17f)
                verticalLineTo(23.15f)
                curveTo(17.167f, 23.1f, 17.329f, 23.063f, 17.487f, 23.038f)
                curveTo(17.646f, 23.013f, 17.817f, 23f, 18f, 23f)
                curveTo(19.1f, 23f, 20.042f, 23.392f, 20.825f, 24.175f)
                curveTo(21.608f, 24.958f, 22f, 25.9f, 22f, 27f)
                curveTo(22f, 28.1f, 21.608f, 29.042f, 20.825f, 29.825f)
                curveTo(20.042f, 30.608f, 19.1f, 31f, 18f, 31f)
                curveTo(17.817f, 31f, 17.646f, 30.987f, 17.487f, 30.962f)
                curveTo(17.329f, 30.938f, 17.167f, 30.9f, 17f, 30.85f)
                verticalLineTo(32f)
                close()
            }
        }
    }.build()
}