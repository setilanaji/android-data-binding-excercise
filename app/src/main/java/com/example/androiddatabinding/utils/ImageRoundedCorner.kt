package com.example.androiddatabinding.utils

import android.graphics.*

//import android.service.autofill.Transformation

class ImageRoundedCorner: com.squareup.picasso.Transformation{
    override fun transform(source: Bitmap?): Bitmap {
        val output = Bitmap.createBitmap(source!!.width, source.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)

        val rect = Rect(0,0, source.width, source.height)

        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = 0xff424242.toInt()
        canvas.drawRoundRect(RectF(rect), 50F, 50F, paint)

        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        if (source != null) {
            canvas.drawBitmap(source, rect, rect, paint)
        }
        source?.recycle()
        return output

    }

    override fun key(): String {
        return "RoundPict"
    }

}