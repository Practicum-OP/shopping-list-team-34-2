package com.diego.shoping_list.presentation.products.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R
import com.diego.shoping_list.domain.model.Product
import com.diego.shoping_list.presentation.common.SwipeState
import com.diego.shoping_list.presentation.products.stateitems.AddProductEvent
import com.diego.shoping_list.presentation.products.stateitems.ProductsIntent
import com.diego.shoping_list.presentation.products.stateitems.ProductsUiState
import com.diego.shoping_list.ui.theme.Dimens
import sh.calvin.reorderable.ReorderableItem
import sh.calvin.reorderable.rememberReorderableLazyListState

@Composable
fun ProductsContent(
    state: ProductsUiState,
    openSwipeItemId: String?,
    onOpenItemChange: (String?) -> Unit,
    onIntent: (ProductsIntent) -> Unit,
    onEditProduct: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        when {
            state.showEmptyPlaceholder -> ShowEmptyScreen(modifier = Modifier.fillMaxSize())

            state.isManualSortMode -> ReorderableProductList(
                products = state.products,
                openItemId = openSwipeItemId,
                onOpenItemChange = onOpenItemChange,
                actions = ReorderableProductListActions(
                    onMove = { from, to -> onIntent(ProductsIntent.ProductMove(from, to)) },
                    onDragStarted = { onIntent(ProductsIntent.DragStarted) },
                    onDragStopped = { onIntent(ProductsIntent.DragStopped) },
                    onEdit = { product ->
                        onIntent(
                            ProductsIntent.AddProduct(
                                AddProductEvent.EditProduct(
                                    product.id
                                )
                            )
                        )
                    },
                    onDelete = { product -> onIntent(ProductsIntent.DeleteProduct(product)) },
                    onToggleChecked = { product, checked ->
                        onIntent(
                            ProductsIntent.ProductCheckedChange(
                                product,
                                checked
                            )
                        )
                    }
                )
            )

            else -> ShowProductList(
                productsList = state.products,
                openItemId = openSwipeItemId,
                onOpenItemChange = onOpenItemChange,
                onEdit = { product -> onEditProduct(product.id) },
                onDelete = { product -> onIntent(ProductsIntent.DeleteProduct(product)) },
                onToggleChecked = { product, checked ->
                    onIntent(ProductsIntent.ProductCheckedChange(product, checked))
                }
            )
        }
    }
}

@Composable
private fun ShowEmptyScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(top = 94.dp),
            painter = painterResource(id = R.drawable.ic_illustration_product_list),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.product_list_empty),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = Dimens.spacingExtraLarge),
        )
        Text(
            text = stringResource(R.string.shopping_list_empty_subtitle),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = Dimens.spacingSmall),
        )
    }
}

@Composable
private fun ShowProductList(
    productsList: List<Product>,
    openItemId: String?,
    onOpenItemChange: (String?) -> Unit,
    onEdit: (Product) -> Unit,
    onDelete: (Product) -> Unit,
    onToggleChecked: (Product, Boolean) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items = productsList, key = { it.id }) { product ->

            SwipeProductBox(
                swipe = SwipeState(
                    itemId = product.id.toString(),
                    openItemId = openItemId,
                    onOpenItemChange = onOpenItemChange
                ),
                onEdit = { onEdit(product) },
                onDelete = { onDelete(product) }
            ) {
                ProductItem(
                    product,
                    onToggleChecked = { checked -> onToggleChecked(product, checked) }
                )
            }
        }
    }
}

@Composable
private fun ReorderableProductList(
    products: List<Product>,
    openItemId: String?,
    onOpenItemChange: (String?) -> Unit,
    actions: ReorderableProductListActions
) {
    val haptic = LocalHapticFeedback.current
    val lazyListState = rememberLazyListState()

    val reorderableState = rememberReorderableLazyListState(lazyListState) { from, to ->
        actions.onMove(from.index, to.index)
        haptic.performHapticFeedback(HapticFeedbackType.SegmentFrequentTick)
    }

    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxSize()
    ) {
        items(products, key = { it.id }) { product ->
            ReorderableItem(reorderableState, key = product.id) {
                SwipeProductBox(
                    swipe = SwipeState(
                        itemId = product.id.toString(),
                        openItemId = openItemId,
                        onOpenItemChange = onOpenItemChange
                    ),
                    onEdit = { actions.onEdit(product) },
                    onDelete = { actions.onDelete(product) }) {
                    ProductItem(
                        product = product,
                        onToggleChecked = { checked ->
                            actions.onToggleChecked(
                                product,
                                checked
                            )
                        },
                        dragHandleModifier = Modifier.draggableHandle(
                            onDragStarted = {
                                haptic.performHapticFeedback(HapticFeedbackType.GestureThresholdActivate)
                                actions.onDragStarted()
                            },
                            onDragStopped = {
                                haptic.performHapticFeedback(HapticFeedbackType.GestureEnd)
                                actions.onDragStopped()
                            }
                        ),
                        dragHandleEnable = true
                    )
                }
            }
        }
    }
}

data class ReorderableProductListActions(
    val onMove: (from: Int, to: Int) -> Unit,
    val onDragStarted: () -> Unit,
    val onDragStopped: () -> Unit,
    val onEdit: (Product) -> Unit,
    val onDelete: (Product) -> Unit,
    val onToggleChecked: (Product, Boolean) -> Unit
)