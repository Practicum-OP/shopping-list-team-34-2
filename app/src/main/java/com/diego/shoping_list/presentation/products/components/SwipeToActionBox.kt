package com.diego.shoping_list.presentation.products.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R

@Composable
fun SwipeToActionBox(
    onSwipeStartToEnd: () -> Unit,   // свайп вправо
    onSwipeEndToStart: () -> Unit,   // свайп влево
    startIcon: Int,
    endIcon: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val dismissState = rememberSwipeToDismissBoxState(
        positionalThreshold = { totalDistance ->
            totalDistance * 0.9F
        },
        confirmValueChange = { value ->
            when (value) {
                SwipeToDismissBoxValue.StartToEnd -> {
                    onSwipeStartToEnd()
                    false
                }

                SwipeToDismissBoxValue.EndToStart -> {
                    onSwipeEndToStart()
                    false
                }

                else -> false
            }
        }
    )
    SwipeToDismissBox(
        state = dismissState,
        backgroundContent = {
            val value = dismissState.dismissDirection
            val config = when (value) {
                SwipeToDismissBoxValue.StartToEnd ->
                    Triple(
                        MaterialTheme.colorScheme.surface,
                        Alignment.CenterStart,
                        R.drawable.ic_edit_product
                    )

                SwipeToDismissBoxValue.EndToStart ->
                    Triple(
                        MaterialTheme.colorScheme.surface,
                        Alignment.CenterEnd,
                        R.drawable.ic_delete_product
                    )

                else -> null
            }
            if (config != null) {
                val (color, alignment, iconRes) = config
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp)
                        .background(color),
                    contentAlignment = alignment
                ) {
                    Icon(
                        painter = painterResource(iconRes),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }
        },
        modifier = modifier
    ) { content() }
}