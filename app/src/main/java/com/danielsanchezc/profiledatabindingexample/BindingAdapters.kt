package com.danielsanchezc.profiledatabindingexample

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestOptions
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("imageUrl", "circle", requireAll = false)
fun setImageUrl(imageView: ImageView, url: String, circle: Boolean = true) {

    val requestOptions =
            if (circle)
                RequestOptions.circleCropTransform()
            else
                RequestOptions.centerCropTransform()

    GlideApp.with(imageView.context)
            .load(url)
            .apply(requestOptions)
            .placeholder(R.drawable.rounded_photo)
            .into(imageView)
}

@BindingAdapter("date", "dateFormat")
fun dateFormat(textView: TextView, date: Date?, format: String) {
    if (date == null) return
    textView.text = SimpleDateFormat(format).format(date)
}