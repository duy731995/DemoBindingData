package com.example.databinding.util

import android.media.Image
import android.widget.ImageView
import androidx.databinding.BindingMethod

@BindingMethod(
    BindingMethod(
        type = ImageView::class
        attibute = "app:srcCompet"
        method = "setImageResource"
    )
)
class MyBindingMethods