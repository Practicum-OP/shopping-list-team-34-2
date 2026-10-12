package com.diego.shoping_list.presentation.shoppingList.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.style.TextOverflow
import com.diego.shoping_list.domain.ListIcon
import com.diego.shoping_list.domain.ShoppingList
import com.diego.shoping_list.domain.mapper.toImageVector
import com.diego.shoping_list.ui.theme.Dimens

@Composable
fun ShoppingListSearchScreen(
    shoppingLists: List<ShoppingList>,
    isDarkTheme: Boolean,
    onClose: () -> Unit,
    onShoppingListClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    var query by rememberSaveable { mutableStateOf("") }
    val results = remember(shoppingLists, query) {
        shoppingLists.filter { it.nameList.contains(query.trim(), ignoreCase = true) }
    }
    val keyboard = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val closeSearch = {
        keyboard?.hide()
        focusManager.clearFocus()
        onClose()
    }
    BackHandler(onBack = closeSearch)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
        topBar = {
            Column(Modifier.statusBarsPadding()) {
                ShoppingListSearchBar(query = query, onQueryChange = { query = it }, onClose = closeSearch)
                if (query.isNotBlank()) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline)
                }
            }
        },
    ) { innerPadding ->
        val contentModifier = Modifier
            .padding(innerPadding)
            .consumeWindowInsets(innerPadding)
            .imePadding()
        when {
            query.isBlank() -> ShoppingListSearchBackdrop(
                shoppingLists = shoppingLists,
                isDarkTheme = isDarkTheme,
                modifier = contentModifier,
            )
            results.isEmpty() -> ShoppingListSearchEmptyState(contentModifier)
            else -> LazyColumn(
                modifier = contentModifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = Dimens.spacingSmall),
            ) {
                items(results, key = { it.id }) { list ->
                    ShoppingListSearchResult(
                        shoppingList = list,
                        onClick = {
                            keyboard?.hide()
                            focusManager.clearFocus()
                            onShoppingListClick(list.id)
                        },
                    )
                }
            }
        }
    }
}

@Composable
private fun ShoppingListSearchBackdrop(
    shoppingLists: List<ShoppingList>,
    isDarkTheme: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .clearAndSetSemantics {},
    ) {
        if (shoppingLists.isEmpty()) {
            ShoppingListEmptyState(isDarkTheme)
        } else {
            LazyColumn(
                contentPadding = PaddingValues(Dimens.screenPadding),
                verticalArrangement = Arrangement.spacedBy(Dimens.listCardSpacing),
                userScrollEnabled = false,
            ) {
                items(shoppingLists, key = { it.id }) { list ->
                    ShoppingListCard(shoppingList = list, onClick = {}, onIconClick = {})
                }
            }
        }
        Box(Modifier.matchParentSize().background(MaterialTheme.colorScheme.scrim.copy(alpha = 0.32f)))
    }
}

@Composable
private fun ShoppingListSearchResult(shoppingList: ShoppingList, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = Dimens.listItemHeight)
            .clickable(onClick = onClick)
            .padding(horizontal = Dimens.spacingSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Dimens.spacingSmall),
    ) {
        Image(
            imageVector = ListIcon.fromKey(shoppingList.iconKey).toImageVector(),
            contentDescription = null,
            modifier = Modifier.size(Dimens.listIconSize),
        )
        Text(
            text = shoppingList.nameList,
            style = MaterialTheme.typography.bodyLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f),
        )
    }
}
