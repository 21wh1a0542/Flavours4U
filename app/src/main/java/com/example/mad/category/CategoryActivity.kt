package com.example.mad.category

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mad.ui.RecipeScreen
//import com.example.mad.ui.ui.LinkingPage
import com.example.mad.ui.ui.theme.MADTheme

class CategoryActivity : ComponentActivity() {
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
                        CategoryScreen(onCategoryItemClicked = {}, onGetStartedClicked = {
                            val supriya = Intent(this, RecipeScreen::class.java)
                            startActivity(supriya)
                        })

                        }
                    }
                }
            }
        }


    @Composable
    fun CategoryScreen(onGetStartedClicked:()->Unit = {}, onCategoryItemClicked: () -> Unit) {
        val viewModel = CategoryViewModel()
        val categoriesState = viewModel.categories.collectAsState()
        val categories = categoriesState.value
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(categories) { category ->
                CategoryItem(category, onCategoryItemClicked)
            }
        }
    }



    //data class CategoryItemData(val categoryTitle: String, val imgUrl: String, val id: String)

    @Composable
    fun CategoryItem(category: Category, onCategoryItemClicked:() -> Unit) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                //.background(Color.Black)
                .clickable {
                           onCategoryItemClicked()
                },

            //elevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = category.imgUrl,
                    contentDescription = category.imgUrl
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = category.categoryTitle,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

