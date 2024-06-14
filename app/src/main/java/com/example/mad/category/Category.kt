package com.example.mad.category

import kotlinx.serialization.Serializable

@Serializable
data class Category (
    val categoryTitle: String,
    val imgUrl: String,
    val id: String
)