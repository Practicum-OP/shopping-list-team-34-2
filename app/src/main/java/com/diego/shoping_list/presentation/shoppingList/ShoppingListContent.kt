package com.diego.shoping_list.presentation.shoppingList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.diego.shoping_list.domain.ShoppingList
import com.diego.shoping_list.ui.theme.Dimens

@Composable
fun ShoppingListContent(
    shoppingLists: List<ShoppingList>,
    onShoppingListClick: (Long) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = Dimens.screenPadding,
            end = Dimens.screenPadding,
            top = contentPadding.calculateTopPadding() + Dimens.spacingSmall,
            bottom = contentPadding.calculateBottomPadding() + Dimens.listBottomSpace
        ),
        verticalArrangement = Arrangement.spacedBy(Dimens.spacingSmall)
    ) {
        items(shoppingLists, key = { it.id }) { shoppingList ->
            ShoppingListCard(
                shoppingList = shoppingList,
                onClick = { onShoppingListClick(shoppingList.id) }
            )
        }
    }
}
