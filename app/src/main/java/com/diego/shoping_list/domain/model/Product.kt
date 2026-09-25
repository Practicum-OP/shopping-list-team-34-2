package com.diego.shoping_list.domain.model

data class Product(
    val id: Long = 0,
    val listId: Long,
    val name: String,
    val quantity: Int,
    val unit: String = "",
    val isChecked: Boolean = false
)