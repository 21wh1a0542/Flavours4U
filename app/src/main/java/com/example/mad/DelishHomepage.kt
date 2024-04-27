package com.example.mad

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mad.ui.theme.MADTheme

class DelishHomepage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BackgroundImage(onGetStartedClicked = {
                        val delishHome = Intent(this, LoginPage::class.java)
                        startActivity(delishHome)
                    })
                }
            }
        }
    }
}
@Composable
fun BackgroundImage(onGetStartedClicked:()->Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bgimg),
            contentDescription = "Background image", modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        )
//        Image(
//            painter = painterResource(id = R.drawable.chef),
//            contentDescription = null,
//            modifier = Modifier
//                .offset(x = 50.dp, y = 50.dp) // Adjust the offset as needed
//                .size(100.dp)
//                .align(Alignment.Center)// Set the size of the overlay image
//        )
        Image(
            painter = painterResource(id = R.drawable.flavours1),
            contentDescription = null,
            modifier = Modifier
                .offset(x = -10.dp, y = -20.dp) // Adjust the offset as needed
                .size(250.dp)
                .align(Alignment.Center)// Set the size of the overlay image
        )
        //val shape = RoundedCornerShape(8.dp)
        Button(
            onClick = {
                onGetStartedClicked()
            },
            modifier = Modifier
                .size(100.dp)
                .offset(x = 10.dp, y = 100.dp)
                .width(20.dp)
                .height(40.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Get started")
        }


    }
}
@Preview
@Composable
fun ScreenContent() {
}
