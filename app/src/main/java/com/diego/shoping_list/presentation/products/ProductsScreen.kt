package com.diego.shoping_list.presentation.products

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.diego.shoping_list.presentation.products.components.ProductsContent
import com.diego.shoping_list.presentation.products.components.ProductsDialogs
import com.diego.shoping_list.presentation.products.components.ProductsEffectsLauncher
import com.diego.shoping_list.presentation.products.components.ProductsScaffold
import com.diego.shoping_list.presentation.products.components.ProductsSheets
import com.diego.shoping_list.presentation.products.stateitems.AddProductEvent
import com.diego.shoping_list.presentation.products.stateitems.ProductsIntent
import org.koin.androidx.compose.koinViewModel

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

    ProductsEffectsLauncher(
        effects = viewModel.effect,
        snackbarHostState = snackbarHostState,
        context = context
    )

    ProductsScaffold(
        snackbarHostState = snackbarHostState,
        onBackClick = onBackClick,
        onIntent = onIntent
    ) { innerPadding ->
        ProductsContent(
            state = state,
            openSwipeItemId = openSwipeItemId,
            onOpenItemChange = { openSwipeItemId = it },
            onIntent = onIntent,
            onEditProduct = { id ->
                onIntent(
                    ProductsIntent.AddProduct(
                        AddProductEvent.EditProduct(
                            id
                        )
                    )
                )
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }

    ProductsSheets(
        state = state,
        onIntent = onIntent,
        onQuerySuggestions = viewModel::suggestionsFor
    )

    ProductsDialogs(
        state = state,
        onIntent = onIntent
    )
}