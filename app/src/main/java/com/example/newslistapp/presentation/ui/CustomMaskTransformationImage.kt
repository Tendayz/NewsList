package com.example.newslistapp.presentation.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import androidx.annotation.DrawableRes
import coil.size.Size
import coil.transform.Transformation

class CustomMaskTransformationImage(
    private val context: Context,
    @DrawableRes private val maskResId: Int,
    override val cacheKey: String = "CustomMaskTransformationImage"
) : Transformation {

    override suspend fun transform(
        input: Bitmap,
        size: Size
    ): Bitmap {
        val mask = BitmapFactory.decodeResource(context.resources, maskResId)
        val scaledMask = Bitmap.createScaledBitmap(mask, input.width, input.height, true)
        val output = Bitmap.createBitmap(input.width, input.height, Bitmap.Config.ARGB_8888)

        val canvas = Canvas(output)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)

        val halfHeight = input.height * 4 / 7
        val scaledImage = Bitmap.createScaledBitmap(input, input.width, halfHeight, true)

        canvas.drawBitmap(scaledImage, 0f, 0f, paint)

        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        canvas.drawBitmap(scaledMask, 0f, 0f, paint)

        return output
    }
}
