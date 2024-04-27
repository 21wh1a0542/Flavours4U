package com.example.mad

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.mad.ui.theme.MADTheme
//import androidx.compose.rememberImagePainter

@Composable
fun ClickableImageButton(
    imageUrl: String,
    onClick: () -> Unit
) {
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = null, // Provide proper content description
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize(align = Alignment.Center)
            .clickable(onClick = onClick)
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .fillMaxSize(),
        contentScale = ContentScale.Fit
    )
}