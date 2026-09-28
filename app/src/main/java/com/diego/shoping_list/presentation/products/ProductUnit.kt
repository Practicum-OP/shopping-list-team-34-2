package com.diego.shoping_list.presentation.products

enum class ProductUnit(val label: String) {
    LITER("л"),
    MILLILITER("мл"),
    PACK("уп"),
    PACKET("пач"),
    PIECE("шт"),
    KILOGRAM("кг"),
    GRAM("гр")
}

val productUnits: List<String> = ProductUnit.entries.map { it.label }