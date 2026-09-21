package com.diego.shoping_list.presentation.shoppingList

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.diego.shoping_list.R
import com.diego.shoping_list.ui.theme.Dimens

@Composable
fun ShoppingListEmptyState(modifier: Modifier = Modifier) {
    val illustration = if (isSystemInDarkTheme()) {
        R.drawable.ic_empty_lists_dark
    } else {
        R.drawable.ic_empty_lists
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.emptyStatePadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(illustration),
            contentDescription = null,
        )
        Text(
            text = stringResource(R.string.shopping_list_empty_title),
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
