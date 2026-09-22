package com.diego.shoping_list.domain.model

data class Product(
    val id: Long = 0,
    val name: String,
    val quantity: Int,
    val unit: String = "",
    val isChecked: Boolean = false
)