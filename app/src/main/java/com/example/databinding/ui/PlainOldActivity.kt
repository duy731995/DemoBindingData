package com.example.databinding.ui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.R
import com.example.databinding.data.Popularity
import com.example.databinding.data.SimpleViewModel
import kotlinx.android.synthetic.main.solution.view.*

class PlainOldActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider.of(this).get(SimpleViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plain_activity)

        updateName()
        updateLikes()
    }
    fun onLike(view: View){
        viewModel.onLike()
        updateLikes()
    }

    private fun updateName(){
        findViewById<TextView>(R.id.plain_name).text = viewModel.name
        findViewById<TextView>(R.id.plain_lastname).text = viewModel.lastname
    }

    private fun updateLikes(){
        findViewById<TextView>(R.id.likes).text = viewModel.likes.toString()
        findViewById<TextView>(R.id.progressBar).progressBar =
            (viewModel.likes * 100/5).coerceAtMost(100)
        val image = findViewById<ImageView>(R.id.imageView)

        val  color = getAssociatedColor(viewModel.popularity, this)

        ImageViewCompat.setImageTintList(image, ColorStateList.valueOf(color))

        image.setImageDrawable(getDrawablePopularity(viewModel.popularity, this ))
    }

    private fun getAssociatedColor(popularity: Popularity, context: Context):Int{
        return when (popularity){
            Popularity.NORMAL -> context.theme.obtainStyledAttributes(
                intArrayOf(android.R.attr.colorForeground)
            ).getColor(0,0x000000)
            Popularity.POPULAR-> ContextCompat.getColor(context, R.color.popular)
            Popularity.STAR-> ContextCompat.getColor(context, R.color.star)
        }
    }

    private fun getDrawablePopularity(popularity: Popularity, context: Context): Drawable?{
        return when(popularity){
            Popularity.NORMAL-> {
                ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp)
            }
            Popularity.POPULAR->{
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
            Popularity.STAR->{
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
        }
    }

}
