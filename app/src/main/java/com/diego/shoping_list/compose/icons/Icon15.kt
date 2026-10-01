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
fun Icon15(
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
): ImageVector = remember(containerColor, contentColor) {
    ImageVector.Builder(
        name = "Icon15",
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
            path(fill = SolidColor(containerColor)) {
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
            path(fill = SolidColor(contentColor)) {
                moveTo(26.5f, 23.75f)
                curveTo(26.15f, 23.75f, 25.854f, 23.629f, 25.612f, 23.388f)
                curveTo(25.371f, 23.146f, 25.25f, 22.85f, 25.25f, 22.5f)
                curveTo(25.25f, 22.15f, 25.371f, 21.854f, 25.612f, 21.612f)
                curveTo(25.854f, 21.371f, 26.15f, 21.25f, 26.5f, 21.25f)
                curveTo(26.85f, 21.25f, 27.146f, 21.371f, 27.388f, 21.612f)
                curveTo(27.629f, 21.854f, 27.75f, 22.15f, 27.75f, 22.5f)
                curveTo(27.75f, 22.85f, 27.629f, 23.146f, 27.388f, 23.388f)
                curveTo(27.146f, 23.629f, 26.85f, 23.75f, 26.5f, 23.75f)
                close()
                moveTo(21.5f, 23.75f)
                curveTo(21.15f, 23.75f, 20.854f, 23.629f, 20.612f, 23.388f)
                curveTo(20.371f, 23.146f, 20.25f, 22.85f, 20.25f, 22.5f)
                curveTo(20.25f, 22.15f, 20.371f, 21.854f, 20.612f, 21.612f)
                curveTo(20.854f, 21.371f, 21.15f, 21.25f, 21.5f, 21.25f)
                curveTo(21.85f, 21.25f, 22.146f, 21.371f, 22.388f, 21.612f)
                curveTo(22.629f, 21.854f, 22.75f, 22.15f, 22.75f, 22.5f)
                curveTo(22.75f, 22.85f, 22.629f, 23.146f, 22.388f, 23.388f)
                curveTo(22.146f, 23.629f, 21.85f, 23.75f, 21.5f, 23.75f)
                close()
                moveTo(24f, 29f)
                curveTo(23f, 29f, 22.096f, 28.725f, 21.288f, 28.175f)
                curveTo(20.479f, 27.625f, 19.883f, 26.9f, 19.5f, 26f)
                horizontalLineTo(28.5f)
                curveTo(28.117f, 26.9f, 27.521f, 27.625f, 26.712f, 28.175f)
                curveTo(25.904f, 28.725f, 25f, 29f, 24f, 29f)
                close()
                moveTo(24f, 33f)
                curveTo(22.75f, 33f, 21.579f, 32.763f, 20.487f, 32.287f)
                curveTo(19.396f, 31.813f, 18.446f, 31.171f, 17.638f, 30.362f)
                curveTo(16.829f, 29.554f, 16.188f, 28.604f, 15.712f, 27.513f)
                curveTo(15.238f, 26.421f, 15f, 25.25f, 15f, 24f)
                curveTo(15f, 22.75f, 15.238f, 21.579f, 15.712f, 20.487f)
                curveTo(16.188f, 19.396f, 16.829f, 18.446f, 17.638f, 17.638f)
                curveTo(18.446f, 16.829f, 19.396f, 16.188f, 20.487f, 15.712f)
                curveTo(21.579f, 15.238f, 22.75f, 15f, 24f, 15f)
                curveTo(25.25f, 15f, 26.421f, 15.238f, 27.513f, 15.712f)
                curveTo(28.604f, 16.188f, 29.554f, 16.829f, 30.362f, 17.638f)
                curveTo(31.171f, 18.446f, 31.813f, 19.396f, 32.287f, 20.487f)
                curveTo(32.763f, 21.579f, 33f, 22.75f, 33f, 24f)
                curveTo(33f, 25.25f, 32.763f, 26.421f, 32.287f, 27.513f)
                curveTo(31.813f, 28.604f, 31.171f, 29.554f, 30.362f, 30.362f)
                curveTo(29.554f, 31.171f, 28.604f, 31.813f, 27.513f, 32.287f)
                curveTo(26.421f, 32.763f, 25.25f, 33f, 24f, 33f)
                close()
                moveTo(24f, 31f)
                curveTo(25.933f, 31f, 27.583f, 30.317f, 28.95f, 28.95f)
                curveTo(30.317f, 27.583f, 31f, 25.933f, 31f, 24f)
                curveTo(31f, 22.067f, 30.317f, 20.417f, 28.95f, 19.05f)
                curveTo(27.583f, 17.683f, 25.933f, 17f, 24f, 17f)
                horizontalLineTo(23.7f)
                curveTo(23.6f, 17f, 23.5f, 17.017f, 23.4f, 17.05f)
                curveTo(23.3f, 17.15f, 23.233f, 17.258f, 23.2f, 17.375f)
                curveTo(23.167f, 17.492f, 23.15f, 17.617f, 23.15f, 17.75f)
                curveTo(23.15f, 18.1f, 23.271f, 18.396f, 23.513f, 18.638f)
                curveTo(23.754f, 18.879f, 24.05f, 19f, 24.4f, 19f)
                curveTo(24.55f, 19f, 24.688f, 18.975f, 24.813f, 18.925f)
                curveTo(24.938f, 18.875f, 25.067f, 18.85f, 25.2f, 18.85f)
                curveTo(25.4f, 18.85f, 25.567f, 18.925f, 25.7f, 19.075f)
                curveTo(25.833f, 19.225f, 25.9f, 19.4f, 25.9f, 19.6f)
                curveTo(25.9f, 19.983f, 25.721f, 20.229f, 25.362f, 20.337f)
                curveTo(25.004f, 20.446f, 24.683f, 20.5f, 24.4f, 20.5f)
                curveTo(23.65f, 20.5f, 23.004f, 20.229f, 22.462f, 19.688f)
                curveTo(21.921f, 19.146f, 21.65f, 18.5f, 21.65f, 17.75f)
                verticalLineTo(17.6f)
                curveTo(21.65f, 17.55f, 21.658f, 17.483f, 21.675f, 17.4f)
                curveTo(20.292f, 17.9f, 19.167f, 18.742f, 18.3f, 19.925f)
                curveTo(17.433f, 21.108f, 17f, 22.467f, 17f, 24f)
                curveTo(17f, 25.933f, 17.683f, 27.583f, 19.05f, 28.95f)
                curveTo(20.417f, 30.317f, 22.067f, 31f, 24f, 31f)
                close()
            }
        }
    }.build()
}