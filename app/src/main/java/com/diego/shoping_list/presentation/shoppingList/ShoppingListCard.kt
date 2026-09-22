package com.diego.shoping_list.presentation.shoppingList

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.diego.shoping_list.domain.ListIcon
import com.diego.shoping_list.domain.ShoppingList
import com.diego.shoping_list.ui.theme.Dimens

@Composable
fun ShoppingListCard(
    shoppingList: ShoppingList,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        shape = RoundedCornerShape(Dimens.cardCornerRadius),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = Dimens.cardElevation
        ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.listItemHeight)
                .clickable(onClick = onClick)
                .padding(start = Dimens.spacingSmall, end = Dimens.screenPadding)
        ) {
            Image(
                painter = painterResource(ListIcon.fromKey(shoppingList.iconKey).resId),
                contentDescription = null,
                modifier = Modifier.size(Dimens.listIconSize)
            )
            Text(
                text = shoppingList.nameList,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = Dimens.spacingSmall)
            )
        }
    }
}
