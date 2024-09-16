package com.example.newslistapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import androidx.compose.ui.platform.LocalContext

@Composable
fun MaskedImage(imageRes: Int, maskRes: Int) {
    val context = LocalContext.current

    val imageLoader = ImageLoader.Builder(context).build()
    val request = ImageRequest.Builder(context)
        .data(imageRes)
        .transformations(CustomMaskTransformationImage(context, maskRes))
        .build()

    Image(
        painter = rememberAsyncImagePainter(request, imageLoader),
        contentDescription = null,
        alignment = Alignment.TopCenter,
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        contentScale = ContentScale.FillBounds
    )
}
