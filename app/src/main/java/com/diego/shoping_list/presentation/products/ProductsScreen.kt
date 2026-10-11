package com.diego.shoping_list.presentation.products

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R
import com.diego.shoping_list.domain.SortMode
import com.diego.shoping_list.domain.model.Product
import com.diego.shoping_list.domain.model.ProductSuggestion
import com.diego.shoping_list.presentation.common.AppBarIcon
import com.diego.shoping_list.presentation.common.AppTopBar
import com.diego.shoping_list.presentation.products.components.AddProductBottomSheetContent
import com.diego.shoping_list.presentation.products.components.ConfirmDialog
import com.diego.shoping_list.presentation.products.components.ProductItem
import com.diego.shoping_list.presentation.products.components.ProductsMenuBSContent
import com.diego.shoping_list.presentation.products.components.SwipeProductBox
import com.diego.shoping_list.presentation.products.stateitems.AddProductEvent
import com.diego.shoping_list.presentation.products.stateitems.AddProductFormState
import com.diego.shoping_list.presentation.products.stateitems.ProductsEffect
import com.diego.shoping_list.presentation.products.stateitems.ProductsError
import com.diego.shoping_list.presentation.products.stateitems.ProductsIntent
import com.diego.shoping_list.presentation.products.stateitems.ProductsMenuEvent
import com.diego.shoping_list.presentation.products.stateitems.ProductsToast
import com.diego.shoping_list.presentation.shoppingList.components.ShoppingListFab
import com.diego.shoping_list.ui.theme.Dimens
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.compose.koinViewModel
import sh.calvin.reorderable.ReorderableItem
import sh.calvin.reorderable.rememberReorderableLazyListState

@Composable
fun ProductsScreen(
    viewModel: ProductsViewModel = koinViewModel(),
    onBackClick: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    val onIntent: (ProductsIntent) -> Unit = viewModel::onIntent
    val context = LocalContext.current

    var openSwipeItemId by rememberSaveable { mutableStateOf<String?>(null) }

    LaunchedEffect(state.isAddSheetVisible, state.isMenuSheetVisible) {
        if (state.isAddSheetVisible || state.isMenuSheetVisible) openSwipeItemId = null
    }

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is ProductsEffect.ShowError -> {
                    val msgRes = when (effect.error) {
                        ProductsError.SaveFailed -> R.string.error_save_product
                        ProductsError.DeleteFailed -> R.string.error_delete_product
                        ProductsError.SaveOrderFailed -> R.string.error_save_order
                        ProductsError.Unknown -> R.string.error_unknown
                    }
                    snackbarHostState.showSnackbar(context.getString(msgRes))
                }

                is ProductsEffect.ShowToast -> {
                    val msgRes = when (effect.toast) {
                        ProductsToast.ProductSaved -> R.string.toast_product_saved
                        ProductsToast.ProductDeleted -> R.string.toast_product_deleted
                    }
                    Toast.makeText(context, context.getString(msgRes), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            AppTopBar(
                title = stringResource(R.string.product_screen_title),
                onBackClick = onBackClick,
                actions = {
                    IconButton(onClick = { onIntent(ProductsIntent.ProductMenuClick) }) {
                        AppBarIcon(
                            iconResId = R.drawable.ic_products_menu,
                            contentDescription = stringResource(R.string.products_menu_icon_description),
                        )
                    }
                }
            )
        },
        floatingActionButton = { ShoppingListFab(onClick = { onIntent(ProductsIntent.AddProductClick) }) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when {
                state.showEmptyPlaceholder -> {
                    ShowEmptyScreen(modifier = Modifier.fillMaxSize())
                }

                state.isManualSortMode -> {
                    ReorderableProductList(
                        products = state.products,
                        openItemId = openSwipeItemId,
                        onOpenItemChange = { openSwipeItemId = it },
                        actions = ReorderableProductListActions(
                            onMove = { from, to -> onIntent(ProductsIntent.ProductMove(from, to)) },
                            onDragStarted = { onIntent(ProductsIntent.DragStarted) },
                            onDragStopped = { onIntent(ProductsIntent.DragStopped) },
                            onEdit = { product ->
                                viewModel.onIntent(
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
                }

                else -> {
                    ShowProductList(
                        productsList = state.products,
                        openItemId = openSwipeItemId,
                        onOpenItemChange = { openSwipeItemId = it },
                        onEdit = { product ->
                            viewModel.onIntent(
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
                }
            }
        }
    }

    if (state.isAddSheetVisible) {
        AddProductBottomSheet(
            state = state.addForm,
            onEvent = { event -> onIntent(ProductsIntent.AddProduct(event)) },
            onDismiss = { onIntent(ProductsIntent.DismissAddProduct) },
            onQuerySuggestions = viewModel::suggestionsFor
        )
    }

    if (state.isMenuSheetVisible) {
        ProductsMenuBottomSheet(
            sortMode = state.sortMode,
            canDeleteAll = state.canDeleteAll,
            canClearChecked = state.canClearChecked,
            onEvent = { event -> onIntent(ProductsIntent.Menu(event)) },
            onDismiss = { onIntent(ProductsIntent.DismissProductMenu) }
        )

    }

    val productToDelete = state.productToDelete
    if (state.isDeleteProductDialogVisible && productToDelete != null) {
        ConfirmDialog(
            title = stringResource(
                R.string.products_dialog_delete_product,
                productToDelete.name,
            ),
            onConfirm = { onIntent(ProductsIntent.ConfirmDeleteProduct) },
            onDismiss = { onIntent(ProductsIntent.DismissDeleteProduct) }
        )
    }

    if (state.isDeleteAllDialogVisible) {
        ConfirmDialog(
            title = stringResource(R.string.products_dialog_delete_all),
            onConfirm = { onIntent(ProductsIntent.Menu(ProductsMenuEvent.ConfirmDeleteAll)) },
            onDismiss = { onIntent(ProductsIntent.Menu(ProductsMenuEvent.DismissDeleteAllDialog)) }
        )
    }

    if (state.isClearCheckedDialogVisible) {
        ConfirmDialog(
            title = stringResource(R.string.products_dialog_clear_checked),
            onConfirm = { onIntent(ProductsIntent.Menu(ProductsMenuEvent.ConfirmClearChecked)) },
            onDismiss = { onIntent(ProductsIntent.Menu(ProductsMenuEvent.DismissClearCheckedDialog)) }
        )
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
                itemId = product.id.toString(),
                openItemId = openItemId,
                onOpenItemChange = onOpenItemChange,
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
                    itemId = product.id.toString(),
                    openItemId = openItemId,
                    onOpenItemChange = onOpenItemChange,
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddProductBottomSheet(
    state: AddProductFormState,
    onEvent: (AddProductEvent) -> Unit,
    onDismiss: () -> Unit,
    onQuerySuggestions: (String) -> Flow<List<ProductSuggestion>>
) {
    val sheetState = rememberModalBottomSheetState(
    )
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        AddProductBottomSheetContent(
            state = state,
            onEvent = onEvent,
            onQuerySuggestions = onQuerySuggestions,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductsMenuBottomSheet(
    sortMode: SortMode,
    canDeleteAll: Boolean,
    canClearChecked: Boolean,
    onEvent: (ProductsMenuEvent) -> Unit,
    onDismiss: () -> Unit
) {
    val menuSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = menuSheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        ProductsMenuBSContent(
            sortMode = sortMode,
            canDeleteAll = canDeleteAll,
            canClearChecked = canClearChecked,
            onEvent = onEvent
        )
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

