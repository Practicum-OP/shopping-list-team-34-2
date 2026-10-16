package com.diego.shoping_list.presentation.products.handlers

import com.diego.shoping_list.domain.api.ProductInListInteractor
import com.diego.shoping_list.domain.model.ProductSuggestion
import com.diego.shoping_list.domain.model.ProductUnit
import com.diego.shoping_list.presentation.common.AppLogger
import com.diego.shoping_list.presentation.products.stateitems.AddProductEvent
import com.diego.shoping_list.presentation.products.stateitems.AddProductFormState
import com.diego.shoping_list.presentation.products.stateitems.ProductsEffect
import com.diego.shoping_list.presentation.products.stateitems.ProductsError
import com.diego.shoping_list.presentation.products.stateitems.ProductsToast
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class AddProductFormHandler(
    private val interactor: ProductInListInteractor,
    private val listId: Long,
    private val context: HandlerContext,
    private val minQuantity: Int = 1,
    private val maxQuantity: Int = 999
) {

    fun onAddProductClick() {
        context.updateState {
            it.copy(isAddSheetVisible = true, addForm = AddProductFormState())
        }
    }

    fun onDismissAddProduct() {
        context.updateState {
            it.copy(isAddSheetVisible = false, addForm = AddProductFormState())
        }
    }

    fun onAddProductEvent(event: AddProductEvent) {
        when (event) {
            is AddProductEvent.NameChange -> onNameChange(event.value)
            is AddProductEvent.QuantityChange -> onQuantityChange(event.value)
            is AddProductEvent.UnitChange -> onUnitChange(event.value)
            is AddProductEvent.SuggestionSelected -> onSuggestionSelected(event.suggestion)
            is AddProductEvent.EditProduct -> onEditProduct(event.productId)
            AddProductEvent.Increment -> onIncrement()
            AddProductEvent.Decrement -> onDecrement()
            AddProductEvent.Submit -> submit()
            AddProductEvent.Reset -> onResetForm()
        }
    }

    private fun onNameChange(value: String) {
        context.updateState {
            it.copy(addForm = it.addForm.copy(name = value, nameError = null))
        }
    }

    private fun onQuantityChange(value: String) {
        val digits = value.filter { it.isDigit() }.take(maxQuantity.toString().length)
        context.updateState {
            it.copy(addForm = it.addForm.copy(quantity = digits, quantityError = null))
        }
    }

    private fun onUnitChange(unit: ProductUnit) {
        context.updateState { it.copy(addForm = it.addForm.copy(unit = unit)) }
    }

    private fun onSuggestionSelected(suggestion: ProductSuggestion) {
        context.updateState { state ->
            state.copy(
                addForm = state.addForm.copy(
                    name = suggestion.name,
                    unit = suggestion.defaultUnit
                )
            )
        }
    }

    private fun onEditProduct(productId: Long) {
        val fresh = context.readState().products.find { it.id == productId } ?: return
        context.updateState {
            it.copy(
                isAddSheetVisible = true,
                addForm = AddProductFormState(
                    editingProduct = fresh,
                    name = fresh.name,
                    quantity = fresh.quantity.toString(),
                    unit = fresh.unit
                )
            )
        }
    }

    private fun onIncrement() {
        context.updateState { state ->
            val current = state.addForm.quantity.toIntOrNull()
            val next = if (current == null) minQuantity else (current + 1).coerceAtMost(maxQuantity)
            state.copy(
                addForm = state.addForm.copy(quantity = next.toString(), quantityError = null)
            )
        }
    }

    private fun onDecrement() {
        context.updateState { state ->
            val current = state.addForm.quantity.toIntOrNull() ?: return@updateState state
            val next = (current - 1).coerceIn(minQuantity, maxQuantity)
            state.copy(addForm = state.addForm.copy(quantity = next.toString()))
        }
    }

    private fun onResetForm() {
        context.updateState { it.copy(addForm = AddProductFormState()) }
    }

    private fun submit() {
        val form = context.readState().addForm
        val validation = validate(form)

        if (validation != null) {
            context.updateState { it.copy(addForm = validation) }
            return
        }

        val qtyValue = form.quantity.toIntOrNull() ?: return
        persist(form, qtyValue)
    }

    private fun validate(form: AddProductFormState): AddProductFormState? {
        val nameError = if (form.name.isBlank()) "Введите название" else null
        val qty = form.quantity.toIntOrNull()
        val quantityError = when {
            qty == null -> "Введите количество"
            qty !in minQuantity..maxQuantity -> "От $minQuantity до $maxQuantity"
            else -> null
        }
        return if (nameError != null || quantityError != null) {
            form.copy(nameError = nameError, quantityError = quantityError)
        } else null
    }

    private fun persist(form: AddProductFormState, qtyValue: Int) {
        context.updateState { it.copy(addForm = it.addForm.copy(isSubmitting = true)) }

        context.scope.launch {
            try {
                val editing = form.editingProduct
                if (editing == null) {
                    interactor.addProduct(
                        listId = listId,
                        name = form.name,
                        quantity = qtyValue,
                        unit = form.unit
                    )
                } else {
                    interactor.updateProduct(
                        editing.copy(name = form.name, quantity = qtyValue, unit = form.unit)
                    )
                }
                context.updateState {
                    it.copy(isAddSheetVisible = false, addForm = AddProductFormState())
                }
                context.sendEffect(ProductsEffect.ShowToast(ProductsToast.ProductSaved))
            } catch (ce: CancellationException) {
                throw ce
            } catch (t: Throwable) {
                AppLogger.e(t, "submitProduct failed")
                context.updateState { it.copy(addForm = it.addForm.copy(isSubmitting = false)) }
                context.sendEffect(ProductsEffect.ShowError(ProductsError.SaveFailed))
            }
        }
    }
}