package com.example.mad.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mad.R
import com.example.mad.ui.ui.theme.MADTheme

 class RecipeScreen : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                MADTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        //Greeting2("Android")
                        CategoryScreen()
                    }
                }
            }
        }
    }
    @Preview
    @Composable
    fun CategoryScreen() {
        val categories = listOf(
            CategoryItemData("Vegetarian", R.drawable.veg),
            CategoryItemData("Non-Vegetarian", R.drawable.non_veg),
            CategoryItemData("Egg", R.drawable.egg),
            CategoryItemData("Popular", R.drawable.popular)
        )
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Add padding to the entire grid
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(categories) { category ->
                        CategoryItem(category = category)
                    }
                }
            }
        }
    }



    data class CategoryItemData(val categoryName: String, val imageResId: Int)

    @Composable
    fun CategoryItem(category: CategoryItemData) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
               //.background(Color.Black)
                .clickable { /* Handle click event for category */ },

            //elevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = category.imageResId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.5f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = category.categoryName,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

