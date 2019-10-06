package com.example.databinding.util

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.databinding.R
import com.example.databinding.data.Popularity

@BindingAdapter ("app:popularityIcon")
val color = getAssociatedColor(popularity, view.context)
    ImageViewCompst.setImageTintList (view, ColorStatelist.valueOf(color))
    view.setImageDrawable(getDrawablePopularity(popularity, view.context))

@BindingAdapter ("app:progressTint")
fun tintPopularity(view: ProgressBar, popularity: Popularity){
    var color = getAssociatedColor(popularity, view.context)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
        view.progressTintList = ColorStateList.valueOf(color)
    }
}

@BindingAdapter (value = ["app:progressSccaled", "android:max"], requireAll = true)
fun setProgress(progressBar: ProgressBar, likes: Int, max: Int ){
    progressBar.progress = (likes * max/5).coerceAtMost(max)
}

@BindingAdapter("app:hideIfZero")
fun hideIfZero (view: View, number: Int){
    view.visibility = if (number == 0)  View.GONE else View.VISIBLE
}

private fun getAssociatedColor(popularity: Popularity, context: Context): Int {
    return when (popularity){
        Popularity.NORMAL -> context.theme.obtainStyledAttributes(
            intArrayOf(android.R.colorForeground)
        ).getColor(0, 0x000000)
        Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
        Popularity.STAR -> ContextCompat.getColor(context, R.color.star)
    }
}

private fun getDrawablePopularity(popularity: Popularity, context: Context): Drawable?{
    return when (popularity){
        Popularity.NORMAL -> {
            ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp)
        }
        Popularity.POPULAR ->{
            ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
        }
        Popularity.STAR ->{
            ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
        }
    }
}