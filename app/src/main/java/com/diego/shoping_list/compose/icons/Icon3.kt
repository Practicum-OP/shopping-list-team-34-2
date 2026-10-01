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
fun Icon3(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon3",
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
                moveTo(30.9f, 33f)
                lineTo(25.425f, 27.525f)
                lineTo(27.525f, 25.425f)
                lineTo(33f, 30.9f)
                lineTo(30.9f, 33f)
                close()
                moveTo(17.1f, 33f)
                lineTo(15f, 30.9f)
                lineTo(21.9f, 24f)
                lineTo(20.2f, 22.3f)
                lineTo(19.5f, 23f)
                lineTo(18.225f, 21.725f)
                verticalLineTo(23.775f)
                lineTo(17.525f, 24.475f)
                lineTo(14.5f, 21.45f)
                lineTo(15.2f, 20.75f)
                horizontalLineTo(17.25f)
                lineTo(16f, 19.5f)
                lineTo(19.55f, 15.95f)
                curveTo(19.883f, 15.617f, 20.242f, 15.375f, 20.625f, 15.225f)
                curveTo(21.008f, 15.075f, 21.4f, 15f, 21.8f, 15f)
                curveTo(22.2f, 15f, 22.592f, 15.075f, 22.975f, 15.225f)
                curveTo(23.358f, 15.375f, 23.717f, 15.617f, 24.05f, 15.95f)
                lineTo(21.75f, 18.25f)
                lineTo(23f, 19.5f)
                lineTo(22.3f, 20.2f)
                lineTo(24f, 21.9f)
                lineTo(26.25f, 19.65f)
                curveTo(26.183f, 19.467f, 26.129f, 19.275f, 26.087f, 19.075f)
                curveTo(26.046f, 18.875f, 26.025f, 18.675f, 26.025f, 18.475f)
                curveTo(26.025f, 17.492f, 26.362f, 16.663f, 27.038f, 15.988f)
                curveTo(27.712f, 15.313f, 28.542f, 14.975f, 29.525f, 14.975f)
                curveTo(29.775f, 14.975f, 30.013f, 15f, 30.237f, 15.05f)
                curveTo(30.462f, 15.1f, 30.692f, 15.175f, 30.925f, 15.275f)
                lineTo(28.45f, 17.75f)
                lineTo(30.25f, 19.55f)
                lineTo(32.725f, 17.075f)
                curveTo(32.842f, 17.308f, 32.921f, 17.538f, 32.963f, 17.763f)
                curveTo(33.004f, 17.987f, 33.025f, 18.225f, 33.025f, 18.475f)
                curveTo(33.025f, 19.458f, 32.688f, 20.288f, 32.013f, 20.962f)
                curveTo(31.337f, 21.638f, 30.508f, 21.975f, 29.525f, 21.975f)
                curveTo(29.325f, 21.975f, 29.125f, 21.958f, 28.925f, 21.925f)
                curveTo(28.725f, 21.892f, 28.533f, 21.833f, 28.35f, 21.75f)
                lineTo(17.1f, 33f)
                close()
            }
        }
    }.build()
}