package com.example.mad

import android.content.Intent
import android.os.Bundle
// android.text.Layout.Alignment
//import android.widget.GridLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mad.ui.RecipeScreen
import com.example.mad.ui.theme.MADTheme


class LoginPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(onGetStartedClicked = {
                        val supriya = Intent(this, RecipeScreen::class.java)

                        startActivity(supriya)
                    })
            }
        }
    }}

@Composable
fun LoginScreen(onGetStartedClicked:()->Unit) {
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    MaterialTheme {
        Column(
            Modifier.padding(16.dp), Arrangement.Center
            //horizontalAlignment = Alignment.
        ) {
            Text(text = "LOGIN",
                modifier = Modifier
                    .padding(bottom = 16.dp)
                )

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Button(onClick = {
                             onGetStartedClicked()
            },
                modifier = Modifier.fillMaxWidth()) {
                Text("Login")
            }
        }
    }
}

    }
@Preview
@Composable
fun ScreenCont(){

}
