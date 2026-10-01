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
fun Icon7(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon7",
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
                moveTo(15f, 34f)
                verticalLineTo(32f)
                horizontalLineTo(17f)
                verticalLineTo(28.8f)
                curveTo(16.417f, 28.6f, 15.938f, 28.246f, 15.563f, 27.737f)
                curveTo(15.188f, 27.229f, 15f, 26.65f, 15f, 26f)
                verticalLineTo(18f)
                horizontalLineTo(21f)
                verticalLineTo(26f)
                curveTo(21f, 26.65f, 20.813f, 27.229f, 20.438f, 27.737f)
                curveTo(20.063f, 28.246f, 19.583f, 28.6f, 19f, 28.8f)
                verticalLineTo(32f)
                horizontalLineTo(21f)
                verticalLineTo(34f)
                horizontalLineTo(15f)
                close()
                moveTo(17f, 23f)
                horizontalLineTo(19f)
                verticalLineTo(20f)
                horizontalLineTo(17f)
                verticalLineTo(23f)
                close()
                moveTo(18f, 27f)
                curveTo(18.283f, 27f, 18.521f, 26.904f, 18.712f, 26.712f)
                curveTo(18.904f, 26.521f, 19f, 26.283f, 19f, 26f)
                verticalLineTo(25f)
                horizontalLineTo(17f)
                verticalLineTo(26f)
                curveTo(17f, 26.283f, 17.096f, 26.521f, 17.288f, 26.712f)
                curveTo(17.479f, 26.904f, 17.717f, 27f, 18f, 27f)
                close()
                moveTo(25f, 34f)
                curveTo(24.45f, 34f, 23.979f, 33.804f, 23.587f, 33.412f)
                curveTo(23.196f, 33.021f, 23f, 32.55f, 23f, 32f)
                verticalLineTo(22.45f)
                curveTo(23f, 22.017f, 23.125f, 21.629f, 23.375f, 21.288f)
                curveTo(23.625f, 20.946f, 23.95f, 20.7f, 24.35f, 20.55f)
                lineTo(25.3f, 20.2f)
                curveTo(25.533f, 20.117f, 25.708f, 19.996f, 25.825f, 19.837f)
                curveTo(25.942f, 19.679f, 26f, 19.483f, 26f, 19.25f)
                verticalLineTo(15f)
                curveTo(26f, 14.717f, 26.096f, 14.479f, 26.288f, 14.288f)
                curveTo(26.479f, 14.096f, 26.717f, 14f, 27f, 14f)
                horizontalLineTo(30f)
                curveTo(30.283f, 14f, 30.521f, 14.096f, 30.712f, 14.288f)
                curveTo(30.904f, 14.479f, 31f, 14.717f, 31f, 15f)
                verticalLineTo(19.25f)
                curveTo(31f, 19.483f, 31.058f, 19.679f, 31.175f, 19.837f)
                curveTo(31.292f, 19.996f, 31.467f, 20.117f, 31.7f, 20.2f)
                lineTo(32.65f, 20.55f)
                curveTo(33.05f, 20.7f, 33.375f, 20.946f, 33.625f, 21.288f)
                curveTo(33.875f, 21.629f, 34f, 22.017f, 34f, 22.45f)
                verticalLineTo(32f)
                curveTo(34f, 32.55f, 33.804f, 33.021f, 33.412f, 33.412f)
                curveTo(33.021f, 33.804f, 32.55f, 34f, 32f, 34f)
                horizontalLineTo(25f)
                close()
                moveTo(28f, 17f)
                horizontalLineTo(29f)
                verticalLineTo(16f)
                horizontalLineTo(28f)
                verticalLineTo(17f)
                close()
                moveTo(25f, 24f)
                horizontalLineTo(32f)
                verticalLineTo(22.45f)
                lineTo(31.05f, 22.1f)
                curveTo(30.417f, 21.867f, 29.917f, 21.5f, 29.55f, 21f)
                curveTo(29.183f, 20.5f, 29f, 19.933f, 29f, 19.3f)
                verticalLineTo(19f)
                horizontalLineTo(28f)
                verticalLineTo(19.3f)
                curveTo(28f, 19.933f, 27.817f, 20.5f, 27.45f, 21f)
                curveTo(27.083f, 21.5f, 26.583f, 21.867f, 25.95f, 22.1f)
                lineTo(25f, 22.45f)
                verticalLineTo(24f)
                close()
                moveTo(25f, 32f)
                horizontalLineTo(32f)
                verticalLineTo(30f)
                horizontalLineTo(25f)
                verticalLineTo(32f)
                close()
                moveTo(25f, 28f)
                horizontalLineTo(32f)
                verticalLineTo(26f)
                horizontalLineTo(25f)
                verticalLineTo(28f)
                close()
            }
        }
    }.build()
}