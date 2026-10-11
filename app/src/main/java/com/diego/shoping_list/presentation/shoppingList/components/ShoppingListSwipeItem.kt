package com.diego.shoping_list.presentation.shoppingList.components

import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.gestures.animateTo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import com.diego.shoping_list.R
import com.diego.shoping_list.presentation.common.SwipeMenuState
import com.diego.shoping_list.presentation.common.SwipeState
import com.diego.shoping_list.ui.theme.Dimens
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun ShoppingListSwipeItem(
    swipe: SwipeState,
    onRenameClick: () -> Unit,
    onCopyClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val actionsWidth = Dimens.swipeActionSize * 3 + Dimens.spacingSmall * 2
    val menuWidth = actionsWidth + Dimens.spacingSmall * 3
    val menuWidthPx = with(LocalDensity.current) { menuWidth.toPx() }
    val swipeState = remember(menuWidthPx) {
        AnchoredDraggableState(
            initialValue = SwipeMenuState.Closed,
            anchors = DraggableAnchors {
                SwipeMenuState.Closed at 0f
                SwipeMenuState.Open at -menuWidthPx
            },
        )
    }
    val scope = rememberCoroutineScope()

    fun closeMenu() {
        scope.launch { swipeState.animateTo(SwipeMenuState.Closed) }
    }

    LaunchedEffect(swipeState.settledValue) {
        when (swipeState.settledValue) {
            SwipeMenuState.Open -> swipe.onOpenItemChange(swipe.itemId)
            SwipeMenuState.Closed -> {
                if (swipe.isOpen) swipe.onOpenItemChange(null)
            }
        }
    }

    LaunchedEffect(swipe.openItemId, swipe.itemId) {
        if (!swipe.isOpen && swipeState.settledValue != SwipeMenuState.Closed) {
            swipeState.animateTo(SwipeMenuState.Closed)
        }
    }

    val isOpen = swipeState.currentValue == SwipeMenuState.Open ||
            swipeState.targetValue == SwipeMenuState.Open

    Box(modifier = modifier.fillMaxWidth()) {
        if (isOpen) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(Dimens.spacingSmall, Alignment.End),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.matchParentSize(),
            ) {
                ShoppingListSwipeButton(
                    iconResId = R.drawable.ic_rename,
                    contentDescription = stringResource(R.string.action_rename),
                    onClick = {
                        onRenameClick()
                        closeMenu()
                    },
                )
                ShoppingListSwipeButton(
                    iconResId = R.drawable.ic_copy,
                    contentDescription = stringResource(R.string.action_copy),
                    onClick = {
                        onCopyClick()
                        closeMenu()
                    },
                )
                ShoppingListSwipeButton(
                    iconResId = R.drawable.ic_delete,
                    contentDescription = stringResource(R.string.action_delete),
                    onClick = {
                        onDeleteClick()
                        closeMenu()
                    },
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset { IntOffset(swipeState.requireOffset().roundToInt(), 0) }
                .anchoredDraggable(swipeState, Orientation.Horizontal),
        ) {
            content()
        }
    }
}
