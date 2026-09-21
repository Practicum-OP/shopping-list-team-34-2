package com.diego.shoping_list.ui.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.diego.shoping_list.R
import com.diego.shoping_list.ui.common.AppBarIcon
import com.diego.shoping_list.ui.common.AppTopBar

@Composable
fun MainTopBar(
    onSearchClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onToggleTheme: () -> Unit,
) {
    val themeModeIcon = if (isSystemInDarkTheme()) {
        R.drawable.ic_theme_mode_dark
    } else {
        R.drawable.ic_theme_mode
    }
    AppTopBar(
        title = stringResource(R.string.main_title),
        actions = {
            IconButton(onClick = onSearchClick) {
                AppBarIcon(
                    iconResId = R.drawable.ic_search,
                    contentDescription = stringResource(R.string.action_search),
                )
            }
            IconButton(onClick = onDeleteClick) {
                AppBarIcon(
                    iconResId = R.drawable.ic_delete,
                    contentDescription = stringResource(R.string.action_delete),
                )
            }
            IconButton(onClick = onToggleTheme) {
                AppBarIcon(
                    iconResId = themeModeIcon,
                    contentDescription = stringResource(R.string.action_toggle_theme),
                )
            }
        },
    )
}
