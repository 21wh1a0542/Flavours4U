package com.example.mad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mad.ui.theme.MADTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CategoryScreen()
                }
            }
        }
    }
}
//fun categoriesList(): Int {}

@Composable
fun CategoryScreen() {
    Column {
        Text(text = "All Categories")
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(CategoriesList()){
                item -> CategoryItemUi(item.imageUrl, item.title)
            }
        }
    }
}
@Composable
fun CategoryItemUi(imageUrl: String, title: String){
    Card {
        Column{
            AsyncImage(
                model = imageUrl,
                contentDescription = imageUrl
            )
            Text(
                text = title,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}
data class CategoryItem(
val imageUrl: String,
val title: String
)

fun CategoriesList(): List<CategoryItem> {
    return listOf(
        CategoryItem("https://i.imgur.com/QkIa5tT.jpeg","nuevo"),
        CategoryItem("https://i.imgur.com/ZANVnHE.jpeg","Electronics") ,
        CategoryItem("https://i.imgur.com/Qphac99.jpeg","Furniture"),
        CategoryItem("https://i.imgur.com/qNOjJje.jpeg","Shoes"),
        CategoryItem("https://i.imgur.com/BG8J0Fj.jpg","Miscellaneous"))
}

