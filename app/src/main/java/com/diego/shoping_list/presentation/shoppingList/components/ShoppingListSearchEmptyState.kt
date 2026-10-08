package com.diego.shoping_list.presentation.shoppingList.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.diego.shoping_list.R
import com.diego.shoping_list.compose.icons.SearchNotFoundIllustration
import com.diego.shoping_list.ui.theme.Dimens

@Composable
fun ShoppingListSearchEmptyState(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = Dimens.emptyStatePadding)
            .padding(top = Dimens.searchEmptyTopPadding, bottom = Dimens.screenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            imageVector = SearchNotFoundIllustration(),
            contentDescription = null,
            modifier = Modifier.size(Dimens.searchIllustrationWidth, Dimens.searchIllustrationHeight),
        )
        Text(
            text = stringResource(R.string.shopping_list_search_not_found_title),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = Dimens.searchEmptyTopPadding),
        )
        Text(
            text = stringResource(R.string.shopping_list_search_not_found_subtitle),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = Dimens.spacingSmall),
        )
    }
}
