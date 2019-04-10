package com.danielsanchezc.profiledatabindingexample

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    GlideApp.with(imageView.context)
        .load(url)
        .apply(RequestOptions.circleCropTransform())
        .placeholder(R.drawable.rounded_photo)
        .into(imageView)
}