package com.diego.shoping_list.presentation.shoppingList

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.diego.shoping_list.domain.ListIcon
import com.diego.shoping_list.ui.theme.Dimens
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListIconSheet(
    onIconSelected: (ListIcon) -> Unit,
    onDismiss: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
    ) {
        FlowRow(
            maxItemsInEachRow = ICONS_IN_ROW,
            horizontalArrangement = Arrangement.spacedBy(
                Dimens.iconPickerSpacing,
                Alignment.CenterHorizontally,
            ),
            verticalArrangement = Arrangement.spacedBy(Dimens.iconPickerSpacing),
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(bottom = Dimens.iconPickerBottomPadding),
        ) {
            ListIcon.entries.forEach { icon ->
                Image(
                    painter = painterResource(icon.resId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(Dimens.iconPickerItemSize)
                        .clip(CircleShape)
                        .clickable {
                            onIconSelected(icon)
                            scope.launch { sheetState.hide() }
                                .invokeOnCompletion { onDismiss() }
                        },
                )
            }
        }
    }
}

private const val ICONS_IN_ROW = 5
