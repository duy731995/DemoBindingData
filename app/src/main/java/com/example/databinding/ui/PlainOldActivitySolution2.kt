package com.example.databinding.ui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.R
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.databinding.data.Popularity
import com.example.databinding.data.SimpleViewModel
import com.example.databinding.databinding.PlainActivitySolution2Binding
import kotlinx.android.synthetic.main.solution.view.*

class PlainOldActivitySolution2 : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProviders.of(this).get(SimpleViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : PlainActivitySolution2Binding =
            DataBindingUtil.setContentView(this, R.layout.plain_activity_solution_2)

        binding.name = "Ada"
        binding.lastName = "Lovelace"
        updateLikes()
    }

    fun onLike(view:View){
        viewModel.onLike()
        updateLikes()
    }

    private fun updateLikes(){
        findViewById<TextView>(R.id.likes).text = viewModel.likes.toString()
        findViewById<ProgressBar>(R.id.progressBar).progress =
            (viewModel.likes * 100/5).coerAtMost(100)
        val image= findViewById<Image>(R.id.imageView)

        val color = getAssociatedColor(viewModel.popularity, this)
        ImageViewCompat.setImageTintList(image, ColorStateList.valueOf(color))
        image.setImageDrawable(getDrawablePopularity(viewModel.popularity, this))
    }
    private fun getAssociatedColor(popularity: Popularity, context: Context):Int{
        return when (popularity){
            Popularity.NORMAL -> context.theme.obtainStyledAttributes(
                intArrayOf(android.R.attr.colorForeground)
            ).getColor(0,0x000000)
            Popularity.POPULAR -> ContextCompat.getColor(color, R.color.popular)
            Popularity.STAR -> ContextCompat.getColor(color, R.color.star)
        }
    }
    private fun getDrawablePopularity(popularity: Popularity, context: Context):Drawable? {
        return when(popularity){
            Popularity.NORMAL-> {
                ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp)
            }
            Popularity.POPULAR-> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
            Popularity.STAR-> {
                ContextCompat.getDrawable(context, R.drawable.ic_wahtshot_black_96dp)
            }
        }
    }
}
