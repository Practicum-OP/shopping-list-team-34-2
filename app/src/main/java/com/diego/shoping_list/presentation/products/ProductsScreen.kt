package com.diego.shoping_list.presentation.products

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R
import com.diego.shoping_list.domain.model.Product
import com.diego.shoping_list.presentation.common.AppTopBar
import com.diego.shoping_list.presentation.products.components.AddProductBottomSheetContent
import com.diego.shoping_list.presentation.products.components.ProductItem
import com.diego.shoping_list.presentation.products.components.SwipeToActionBox
import com.diego.shoping_list.presentation.shoppingList.ShoppingListFab
import com.diego.shoping_list.ui.theme.Dimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductsScreen(
    viewModel: ProductsViewModel = koinViewModel(),
    onBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AppTopBar(
                title = stringResource(R.string.product_screen_title),
                onBackClick = onBackClick
            )
        },
        floatingActionButton = { ShoppingListFab(onClick = viewModel::onAddProductClick) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (uiState.isAddSheetVisible) {
                ShowProductList(
                    uiState.products,
                    onEdit = { },
                    onDelete = { viewModel.deleteProduct(it) })
            } else {
                when (uiState.content) {
                    is ProductScreenState.IsEmpty -> {
                        ShowEmptyScreen()
                    }

                    is ProductScreenState.ShowShoppingList -> {
                        ShowProductList(
                            uiState.products,
                            onEdit = { },
                            onDelete = { viewModel.deleteProduct(it) })
                    }
                }

            }
        }
    }

    if (uiState.isAddSheetVisible) {
        AddProductBottomSheet(viewModel, onDismiss = viewModel::onDismissAddProduct)
    }
}

@Composable
private fun ShowEmptyScreen() {
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

@Composable
private fun ShowProductList(
    productsList: List<Product>,
    onEdit: (Product) -> Unit,
    onDelete: (Product) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items = productsList, key = { it.id }) { product ->
            SwipeToActionBox(
                onSwipeStartToEnd = { onEdit(product) },
                onSwipeEndToStart = { onDelete(product) },
                startIcon = R.drawable.ic_search,
                endIcon = R.drawable.ic_delete,
                modifier = Modifier.animateItem()
            ) {
                ProductItem(
                    product,
                    onToggleChecked = { },
                    modifier = Modifier.animateItem(
                        fadeInSpec = tween(300),
                        fadeOutSpec = tween(400),
                        placementSpec = tween(
                            durationMillis = 600,
                            easing = FastOutSlowInEasing
                        )
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddProductBottomSheet(viewModel: ProductsViewModel, onDismiss: () -> Unit) {
    val sheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        AddProductBottomSheetContent(viewModel)
    }
}
