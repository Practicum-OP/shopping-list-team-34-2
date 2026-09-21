package com.diego.shoping_list.ui.main

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.diego.shoping_list.R

@Composable
fun MainFab(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(
            painter = painterResource(R.drawable.ic_fab_add),
            contentDescription = stringResource(R.string.action_add_list),
        )
    }
}
