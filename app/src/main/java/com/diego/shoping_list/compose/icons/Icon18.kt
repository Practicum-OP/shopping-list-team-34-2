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
fun Icon18(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon18",
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
                moveTo(18f, 22.95f)
                lineTo(17f, 23.5f)
                curveTo(16.767f, 23.633f, 16.517f, 23.667f, 16.25f, 23.6f)
                curveTo(15.983f, 23.533f, 15.783f, 23.383f, 15.65f, 23.15f)
                lineTo(13.65f, 19.65f)
                curveTo(13.517f, 19.417f, 13.483f, 19.167f, 13.55f, 18.9f)
                curveTo(13.617f, 18.633f, 13.767f, 18.433f, 14f, 18.3f)
                lineTo(19.75f, 15f)
                horizontalLineTo(21.5f)
                curveTo(21.65f, 15f, 21.771f, 15.046f, 21.862f, 15.137f)
                curveTo(21.954f, 15.229f, 22f, 15.35f, 22f, 15.5f)
                verticalLineTo(16f)
                curveTo(22f, 16.55f, 22.196f, 17.021f, 22.587f, 17.413f)
                curveTo(22.979f, 17.804f, 23.45f, 18f, 24f, 18f)
                curveTo(24.55f, 18f, 25.021f, 17.804f, 25.412f, 17.413f)
                curveTo(25.804f, 17.021f, 26f, 16.55f, 26f, 16f)
                verticalLineTo(15.5f)
                curveTo(26f, 15.35f, 26.046f, 15.229f, 26.137f, 15.137f)
                curveTo(26.229f, 15.046f, 26.35f, 15f, 26.5f, 15f)
                horizontalLineTo(28.25f)
                lineTo(34f, 18.3f)
                curveTo(34.233f, 18.433f, 34.383f, 18.633f, 34.45f, 18.9f)
                curveTo(34.517f, 19.167f, 34.483f, 19.417f, 34.35f, 19.65f)
                lineTo(32.35f, 23.15f)
                curveTo(32.217f, 23.383f, 32.021f, 23.529f, 31.762f, 23.587f)
                curveTo(31.504f, 23.646f, 31.25f, 23.608f, 31f, 23.475f)
                lineTo(30f, 22.975f)
                verticalLineTo(32f)
                curveTo(30f, 32.283f, 29.904f, 32.521f, 29.712f, 32.713f)
                curveTo(29.521f, 32.904f, 29.283f, 33f, 29f, 33f)
                horizontalLineTo(19f)
                curveTo(18.717f, 33f, 18.479f, 32.904f, 18.287f, 32.713f)
                curveTo(18.096f, 32.521f, 18f, 32.283f, 18f, 32f)
                verticalLineTo(22.95f)
                close()
                moveTo(20f, 19.6f)
                verticalLineTo(31f)
                horizontalLineTo(28f)
                verticalLineTo(19.6f)
                lineTo(31.1f, 21.3f)
                lineTo(32.15f, 19.55f)
                lineTo(27.85f, 17.05f)
                curveTo(27.6f, 17.9f, 27.129f, 18.604f, 26.437f, 19.163f)
                curveTo(25.746f, 19.721f, 24.933f, 20f, 24f, 20f)
                curveTo(23.067f, 20f, 22.254f, 19.721f, 21.562f, 19.163f)
                curveTo(20.871f, 18.604f, 20.4f, 17.9f, 20.15f, 17.05f)
                lineTo(15.85f, 19.55f)
                lineTo(16.9f, 21.3f)
                lineTo(20f, 19.6f)
                close()
            }
        }
    }.build()
}