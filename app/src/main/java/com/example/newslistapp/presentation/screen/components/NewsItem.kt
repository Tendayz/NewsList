package com.example.newslistapp.presentation.screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newslistapp.R
import com.example.newslistapp.domain.NewsModel
import com.example.newslistapp.presentation.ui.MaskedImage

@Composable
fun NewsItem(news: NewsModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .height(130.dp)
            .paint(
                painter = painterResource(id = R.drawable.parallelogram),
                contentScale = ContentScale.FillBounds
            )
    ) {
        Box {
            MaskedImage(
                imageRes = R.drawable.image_test1,
                maskRes = R.drawable.parallelogram
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp, start = 28.dp),
            ) {
                Text(
                    text = news.title,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(includeFontPadding = false)
                    ),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.White,
                )
                Text(
                    text = news.date,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(includeFontPadding = false)
                    ),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}
