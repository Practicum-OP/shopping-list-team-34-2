package com.diego.shoping_list.presentation.products.handlers

import com.diego.shoping_list.data.settings.SortModeRepository
import com.diego.shoping_list.domain.SortMode
import com.diego.shoping_list.domain.api.ProductInListInteractor
import com.diego.shoping_list.presentation.common.AppLogger
import com.diego.shoping_list.presentation.products.stateitems.ProductsEffect
import com.diego.shoping_list.presentation.products.stateitems.ProductsError
import com.diego.shoping_list.presentation.products.stateitems.ProductsMenuEvent
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class ProductsMenuHandler(
    private val interactor: ProductInListInteractor,
    private val sortModeRepository: SortModeRepository,
    private val listId: Long,
    private val context: HandlerContext
) {

    fun onProductMenuClick() {
        context.updateState { it.copy(isMenuSheetVisible = true) }
    }

    fun onDismissProductMenu() {
        context.updateState { it.copy(isMenuSheetVisible = false) }
    }

    fun onProductMenuEvent(event: ProductsMenuEvent) {
        when (event) {
            ProductsMenuEvent.DeleteAll -> showDeleteAllDialog()
            ProductsMenuEvent.ClearChecked -> showClearCheckedDialog()
            ProductsMenuEvent.ConfirmDeleteAll -> confirmDeleteAll()
            ProductsMenuEvent.DismissDeleteAllDialog -> dismissDeleteAllDialog()
            ProductsMenuEvent.ConfirmClearChecked -> confirmClearChecked()
            ProductsMenuEvent.DismissClearCheckedDialog -> dismissClearCheckedDialog()
            ProductsMenuEvent.SortByAlphabet -> sortBy(SortMode.ALPHABETICAL)
            ProductsMenuEvent.SortByUser -> sortBy(SortMode.MANUAL)
        }
    }

    private fun showDeleteAllDialog() {
        context.updateState {
            it.copy(isMenuSheetVisible = false, isDeleteAllDialogVisible = true)
        }
    }

    private fun showClearCheckedDialog() {
        context.updateState {
            it.copy(isMenuSheetVisible = false, isClearCheckedDialogVisible = true)
        }
    }

    private fun confirmDeleteAll() {
        context.updateState { it.copy(isDeleteAllDialogVisible = false) }
        context.scope.launch {
            try {
                interactor.deleteAllInList(listId)
            } catch (ce: CancellationException) {
                throw ce
            } catch (t: Throwable) {
                AppLogger.e(t, "deleteAllInList($listId) failed")
                context.sendEffect(ProductsEffect.ShowError(ProductsError.DeleteFailed))
            }
        }
    }

    private fun dismissDeleteAllDialog() {
        context.updateState { it.copy(isDeleteAllDialogVisible = false) }
    }

    private fun confirmClearChecked() {
        context.updateState { it.copy(isClearCheckedDialogVisible = false) }
        context.scope.launch {
            try {
                interactor.deleteCheckedInList(listId)
            } catch (ce: CancellationException) {
                throw ce
            } catch (t: Throwable) {
                AppLogger.e(t, "deleteCheckedInList($listId) failed")
                context.sendEffect(ProductsEffect.ShowError(ProductsError.DeleteFailed))
            }
        }
    }

    private fun dismissClearCheckedDialog() {
        context.updateState { it.copy(isClearCheckedDialogVisible = false) }
    }

    private fun sortBy(mode: SortMode) {
        context.scope.launch { sortModeRepository.save(listId, mode) }
        onDismissProductMenu()
    }
}