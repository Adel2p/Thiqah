package com.ebc.ipnapplication.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Mohamed Adel on 24/01/18.
 */
internal fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .asBitmap()
        .centerCrop()
        .into(this)
}