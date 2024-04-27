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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mad.ui.theme.MADTheme

class Products : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductScreen()
                }
            }
        }
    }
}
@Composable
fun ProductItemUi(title: String,price: Int,img: String){
    Column {
        AsyncImage(model = img , contentDescription = title )
        Text(text = title)
        Text(text=price.toString())
    }

}
data class ProductItem(
    val title: String,
    val price: Int,
    val img: String,
)

fun productList(): List<ProductItem>{
    return listOf(
        ProductItem("Classic White Tee - Timeless Style and Comfort",73,"https://i.imgur.com/qNOjJje.jpeg"),
        ProductItem("Classic Black T-Shirt",32,"https://i.imgur.com/9DqEOV5.jpeg"),
        ProductItem("Sleek White & Orange Wireless Gaming Controller",102,"https://i.imgur.com/ZANVnHE.jpeg"),
        ProductItem("Headphone & Inked Earbud Set",44,"https://i.imgur.com/yVeIeDa.jpeg"),
        ProductItem("Headphones",52,"https://i.imgur.com/SolkFEB.jpeg"),
        ProductItem("2-Slice Toaster",100,"https://i.imgur.com/keVCVIa.jpeg"),
        ProductItem("Wireless Computer Mouse",120,"https://i.imgur.com/w3Y8NwQ.jpeg"),
        ProductItem("Shoe",100, "https://i.imgur.com/Au8J9sX.jpeg")
    )
}
@Preview
@Composable
fun ProductScreen(){
    Column{
        Text(text = "Clothes",
            fontSize = 35.sp
        )
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(productList()){
                    item -> ProductItemUi(item.title,item.price,item.img)
            }
        }
    }
}