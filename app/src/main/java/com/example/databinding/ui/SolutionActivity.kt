package com.example.databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.R
import androidx.lifecycle.ViewModelProviders
import com.example.databinding.data.SimpleViewModelSolution
import com.example.databinding.databinding.SolutionBinding

class SolutionActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(SimpleViewModelSolution::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bingding: SolutionBinding =
            DataBindingUtil.setContentView(this, R.layout.solution)
        bingding.lifecycleOwner = this
        bingding.viewmodel = viewModel
    }
}
