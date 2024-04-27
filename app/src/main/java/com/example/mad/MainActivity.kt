package com.example.mad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mad.ui.theme.MADTheme
import java.util.Locale.Category

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                  Column {
                    Greeting()
                    HelloName()
                    GreetingPreview()
                    Screen()
                  }
                }
            }
        }
    }
}

@Preview
@Composable
fun CategoryItem(){
    Column {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "" ,
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
        )
        Text(text = "category title")
    }
}

@Preview
@Composable
fun Greeting(name: String = "World!", modifier: Modifier = Modifier) {
    Column {
        Button(
            onClick = { },
            modifier = Modifier
                .width(150.dp)
                .padding(20.dp)
                .border(6.dp, Color.Magenta)
        ) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HelloName(){
    Greeting("Improve 10X")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MADTheme {
       Greeting("Android")
    }
}

@Composable
fun HttpStatusCodeButton(code: String){
    Button(onClick = { /*TODO*/ },
    modifier = Modifier.padding(20.dp)
    ) {
                Text(text = code)
            }
        }

@Preview
@Composable
fun FirstRow(){
    Row(
        modifier = Modifier
            .background(Color.Cyan)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        HttpStatusCodeButton(code = "200")
        HttpStatusCodeButton(code = "201")
        HttpStatusCodeButton(code = "202")
    }
}
@Preview
@Composable
fun SecondRow(){
    Row {
        HttpStatusCodeButton(code = "400")
        HttpStatusCodeButton(code = "401")
        HttpStatusCodeButton(code = "402")
    }
}
@Preview
@Composable
fun ThirdRow(){
    Row {
        HttpStatusCodeButton(code = "403")
        HttpStatusCodeButton(code = "404")
        HttpStatusCodeButton(code = "405")
    }
}

/*
@Preview
@Composable
fun HttpCodeGrid(){
    Column{
        FirstRow()
        SecondRow()
        ThirdRow()
    }
}
*/

@Preview
@Composable
fun HttpCodeGrid() {
    Column {
        Row {
            HttpStatusCodeButton(code = "200")
            HttpStatusCodeButton(code = "201")
            HttpStatusCodeButton(code = "202")
        }
        Row {
            HttpStatusCodeButton(code = "400")
            HttpStatusCodeButton(code = "401")
            HttpStatusCodeButton(code = "402")
        }
        Row {
            HttpStatusCodeButton(code = "403")
            HttpStatusCodeButton(code = "404")
            HttpStatusCodeButton(code = "405")
        }
    }
}
@Preview
@Composable
fun HttpCodeImage(){
    AsyncImage(model = "https://images.rawpixel.com/image_png_800/czNmcy1wcml2YXRlL3Jhd3BpeGVsX2ltYWdlcy93ZWJzaXRlX2NvbnRlbnQvam9iNjgwLTE2Ni1wLWwxZGJ1cTN2LnBuZw.png",
        contentDescription = null,
        modifier = Modifier.fillMaxSize())
}
@Preview
@Composable
fun Screen(){
    Column {
        HttpCodeGrid()
        HttpCodeImage()
    }
}