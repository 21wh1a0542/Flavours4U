package com.example.mad.category

import com.example.mad.category.Category
import com.example.mad.KtorClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CategoryRepository {

    suspend fun getCategories(): List<Category> {
        val response = KtorClient.httpClient
            .get("https://crudcrud.com/api/99ca3df57f9d4c08a219b925e9fd402e/categories")
            .body<List<Category>>()
        return response
    }

}