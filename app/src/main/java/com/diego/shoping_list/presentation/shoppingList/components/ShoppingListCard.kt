package com.diego.shoping_list.presentation.shoppingList.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R
import com.diego.shoping_list.domain.ListIcon
import com.diego.shoping_list.domain.ShoppingList
import com.diego.shoping_list.domain.mapper.toImageVector
import com.diego.shoping_list.ui.theme.Dimens

@Composable
fun ShoppingListCard(
    shoppingList: ShoppingList,
    onClick: () -> Unit,
    onIconClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(Dimens.cardCornerRadius)
    Card(
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface
        ),
        modifier = modifier
            .fillMaxWidth()
            .dropShadow(
                shape = shape,
                shadow = Shadow(
                    radius = 3.dp,
                    spread = 1.dp,
                    color = Color.Black.copy(alpha = 0.15f),
                    offset = DpOffset(0.dp, 1.dp)
                )
            )
            .dropShadow(
                shape = shape,
                shadow = Shadow(
                    radius = 2.dp,
                    color = Color.Black.copy(alpha = 0.30f),
                    offset = DpOffset(0.dp, 1.dp)
                )
            )
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
                imageVector = ListIcon.fromKey(shoppingList.iconKey).toImageVector(),
                contentDescription = stringResource(R.string.shopping_list_change_icon),
                modifier = Modifier
                    .size(Dimens.listIconSize)
                    .clip(CircleShape)
                    .clickable(onClick = onIconClick)
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
