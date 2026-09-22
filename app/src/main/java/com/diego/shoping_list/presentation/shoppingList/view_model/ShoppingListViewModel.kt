package com.diego.shoping_list.presentation.shoppingList.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diego.shoping_list.domain.interactor.ShoppingListInteractor
import com.diego.shoping_list.presentation.shoppingList.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShoppingListViewModel(
    private val interactor: ShoppingListInteractor
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Empty)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            interactor.getLists().collect { lists ->
                _uiState.value = if (lists.isEmpty()) {
                    UiState.Empty
                } else {
                    UiState.Content(lists)
                }
            }
        }
    }

    fun insertList(name: String) {
        viewModelScope.launch {
            interactor.addList(name)
        }
    }
}
